/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pinjam;

import Model.Pinjam;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author budhidarmap
 */
public class testPengembalian {
    public static void main(String[] args) {
        String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
        Pinjam p = new Pinjam();
        p.Pengembalian(timeStamp, "9780596529260", "145314000");
    }
}
