package com.studybuddy.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.studybuddy.firebase.model.HelpItem;
import com.studybuddy.firebase.model.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class FirebaseDatabaseHandler {

    private DatabaseReference databaseReference;
    private String childName;

    public FirebaseDatabaseHandler(final FirebaseDatabase firebaseDatabase, final String childName) {
        this.databaseReference = firebaseDatabase.getReference(childName);
        this.childName = childName;
    }

    public ArrayList<HelpItem> getAllHelpItems() {
        ArrayList<HelpItem> toReturn = new ArrayList<>();

        JSONObject allHelpItemsJson = getDatabaseJson();

        if (allHelpItemsJson != null) {

            System.out.println(allHelpItemsJson);

            Iterator<String> keys = allHelpItemsJson.keys();
            System.out.println("Size is ......... " + allHelpItemsJson.length());

            while (keys.hasNext()) {
                HelpItem helpItem = new HelpItem();

                try {
                    String key = keys.next();
                    JSONObject val = allHelpItemsJson.getJSONObject(key);

                    helpItem.setAdditionalInformation(val.getString("additionalInformation"));
                    helpItem.setClassName(val.getString("className"));
                    helpItem.setPostTime(val.getLong("postTime"));

                    JSONObject userJson = val.getJSONObject("user");
                    helpItem.setUser(new User()
                            .setEmail(userJson.getString("email"))
                            .setUid(userJson.getString("uid")));

                    toReturn.add(helpItem);
                } catch (Exception e) { /* Nada */ }
            }
        }

        return toReturn;
    }

    public boolean addNewHelpItem(final HelpItem helpItem) {
        String testId = databaseReference.push().getKey();
        databaseReference.child(testId).setValue(helpItem);

        return false;
    }

    private JSONObject getDatabaseJson() {
        JSONObject json = null;
        try {
            HttpRequestHandler handler = new HttpRequestHandler();
            String response = handler.execute(createUrl()).get();
            json = new JSONObject(response);
        } catch (Exception e) { /* Do Nothing */ }

        return json;
    }

    private String createUrl() {
        return "https://umlstudy-e962f.firebaseio.com/" + childName + ".json";
    }
}
