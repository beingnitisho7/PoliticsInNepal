package com.example.ramesh.politicsinnepal.Adapters;

import com.example.ramesh.politicsinnepal.R;

/**
 * Created by ramesh on 10/23/17.
 */

public class PartyData {

    static String[] title = new String[] {
            "नेपाल कम्युनिष्ट पार्टी (एकीकृत मार्क्सवादी-लेनिनवादी)",
            "नेपाली काँग्रेस",
            "राष्ट्रिय जनशक्ति पार्टी",
            "राष्ट्रिय प्रजातन्त्र पार्टी",
            "एकीकृत नेपाल कम्युनिष्ट पार्टी (माओवादी)",
            "विवेकशील साझा पार्टी",
    };

    public static int[] picturePath = new int[] {
            R.drawable.aboutdev,
            R.drawable.desclaimer,
            R.drawable.education,
            R.drawable.aboutdev,
            R.drawable.poll,
            R.drawable.candidates,
    };

    public static String[] estDates = new String[] {
            "20-11-2056",
            "02-01-2050",
            "14-12-2060",
            "22-10-2040",
            "30-05-2070",
            "2004-2073",

    };

    public static String[] extraInfo = new String[] {
            "Ext 1",
            "Ext 2",
            "Ext 3",
            "Ext 4",
            "Ext 5",
            "Ext 6",
    };
public static String[] getTitle() {
    return title;
}public static void setTitle(String[] title) {
    PartyData.title = title;
}}
