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
public class RipDoneEvent extends EventObject {
    private String _data;
    public RipDoneEvent(Object source, String data) {
        super( source );
        _data = data;
    }
    public String getData() {
        return _data;
    }
}
