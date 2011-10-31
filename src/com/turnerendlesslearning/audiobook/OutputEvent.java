/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.turnerendlesslearning.audiobook;

import java.util.EventObject;

/**
 *
 * @author turnermic
 */
public class OutputEvent extends EventObject {
    private String _data;
    public OutputEvent(Object source, String data) {
        super( source );
        _data = data;
    }
    public String getData() {
        return _data;
    }
}
