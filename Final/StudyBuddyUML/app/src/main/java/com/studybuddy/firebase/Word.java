/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.studybuddy.firebase;

/**
 * It contains the course name and the course number
 */
public class Word {

    private String courseNumber;

    private String courseName;

    private String courseInfo;

    private String theEmail;


    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(String defaultCourseName, String defaultCourseNumber) {
        courseNumber = defaultCourseName;
        courseName = defaultCourseNumber;
    }

    public Word(String defaultCourseName, String defaultCourseInfo, String defaultEmail){
        theEmail = defaultEmail;
        courseInfo = defaultCourseInfo;
        courseName = defaultCourseName;
    }

    /**
     * Get the courseNumber of the word.
     */
    public String getCourseNumber() {
        return courseNumber;
    }

    /**
     * Get the courseName of the word.
     */
    public String getCourseName() {
        return courseName;
    }


}