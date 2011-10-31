/*
 * Copyright (C) 2011 Michael Turner <michael at turnerendlesslearning.com>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.turnerendlesslearning.audiobook;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingWorker;


public class RipSwingWorker extends SwingWorker {

    public String outputText = "";
    private String _outputDirectory = "";
    public boolean disableParanoia = false;
    public boolean useExternalDrive = false;

    private List _listeners = new ArrayList();
    private List ripDoneListeners = new ArrayList();

    public void setOutputDirectory(String dir) {
        _outputDirectory = dir;
    }

    public synchronized void addRipDoneListener(RipDoneListener rdl) {
        ripDoneListeners.add(rdl);
    }

    public synchronized void addOutputListener( OutputListener l ) {
        _listeners.add( l );
    }

    public synchronized void removeOutputListener( OutputListener l ) {
        _listeners.remove( l );
    }
    public synchronized void removeRipDoneListener(RipDoneListener rdl) {
        ripDoneListeners.remove( rdl );
    }

    private synchronized void _fireOutputEvent(String data) {
        OutputEvent o = new OutputEvent( this, data );
        Iterator listeners = _listeners.iterator();
        while( listeners.hasNext() ) {
            ( (OutputListener) listeners.next() ).outputReceived( o );
        }
    }

    private synchronized void _fireRipDoneEvent(String data) {
        RipDoneEvent rde = new RipDoneEvent( this, data );
        Iterator listeners = ripDoneListeners.iterator();
        while( listeners.hasNext() ) {
            ( (RipDoneListener) listeners.next() ).ripDone(rde);
        }
    }



    @Override
    protected Object doInBackground() throws Exception {
        Runtime rt = Runtime.getRuntime();
        int commandSize = 4;
        //if(useExternalDrive) {
        //    commandSize += 2;
        //}
        
        String[] command = new String[commandSize];
        command[0] = "cdparanoia";
        command[1] = "-Bv";
        
        if(this.useExternalDrive) {
            command[2] = "-d";
            command[3] = "/dev/sr1";
        } else {
            command[2] = "-d";
            command[3] = "/dev/sr0";
        }
        
        if(this.disableParanoia) {
        	command[1] += "Z";
        } else {
        	command[1] += "z=2";
        }
        
        System.out.println(command[0]);
        System.out.println(command[1]);
        System.out.println(command[2]);
        System.out.println(command[3]);
        
        
        //command[5] = "-v";
        //command[4] = "-d /dev/sr1";
        String s = null;
         try {

	    // run the Unix "ps -ef" command
            // using the Runtime exec method:
            File f = new File(_outputDirectory);
            if(!f.exists()) {
                f.mkdirs();
            }

            Process p = rt.exec(command, null, new File(_outputDirectory));

            BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
            //System.out.println("Here is the standard output of the command:\n");
            //while ((s = stdInput.readLine()) != null) {
            //    _fireOutputEvent(s);
            //}

            // read any errors from the attempted command
            //System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                _fireOutputEvent(s);
            }

            p.waitFor();

        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            System.out.println(e.getStackTrace());
            System.exit(-1);
        }

        this._fireRipDoneEvent(null);
        return null;
    }

    private class textArea {

        public textArea() {
        }
    }

}
