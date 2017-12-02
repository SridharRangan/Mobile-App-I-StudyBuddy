package com.example.android.StudyBuddy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("COMP.4040", "Analysis of Algorithms"));
        words.add(new Word("COMP.4200", "Artifical Intelligence"));
        words.add(new Word("MATH.1310", "Calculus I"));
        words.add(new Word("MATH.1320", "Calculus II"));
        words.add(new Word("MATH.1320", "College Writing I"));
        words.add(new Word("MATH.1320", "College Writing II"));
        words.add(new Word("COMP.1010", "Computing I"));
        words.add(new Word("COMP.1020", "Computing II"));
        words.add(new Word("COMP.2010", "Computing III"));
        words.add(new Word("COMP.2030", "Comp Org. & Assembly Lang"));
        words.add(new Word("COMP.2040", "Computing IV"));
        words.add(new Word("COMP.3050", "Computer Architecture"));
        words.add(new Word("COMP.3090", "Database I"));
        words.add(new Word("COMP.3100", "Database II"));
        words.add(new Word("COMP.4210", "Data Mining"));
        words.add(new Word("MATH.3210", "Discrete Structures I"));
        words.add(new Word("MATH.3220", "Discrete Structures II"));
        words.add(new Word("COMP.3040", "Foundations of Comp. Science"));
        words.add(new Word("COMP.4610", "Graphical User Interface Programming I"));
        words.add(new Word("COMP.4620", "Graphical User Interface Programming II"));
        words.add(new Word("COMP.3080", "Intro to Operating Systems"));
        words.add(new Word("EECE.2650", "Logic Design"));
        words.add(new Word("COMP.4220", "Machine Learning"));
        words.add(new Word("COMP.4630", "Mobile Application I"));
        words.add(new Word("COMP.4631", "Mobile Application II"));
        words.add(new Word("COMP.4500", "Mobile Robotics I"));
        words.add(new Word("COMP.4510", "Mobile Robotics II"));
        words.add(new Word("ENGL.2200", "Oral & Written Communications"));
        words.add(new Word("MATH.3860", "Probability & Statistics I"));
        words.add(new Word("COMP.4110", "Software Engineering I"));
        words.add(new Word("COMP.4120", "Software Engineering II"));


        WordAdapter adapter = new WordAdapter(this, words, R.color.background_color_1);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
