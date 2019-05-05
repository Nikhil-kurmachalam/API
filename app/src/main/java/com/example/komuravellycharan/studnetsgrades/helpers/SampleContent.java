package com.example.komuravellycharan.studnetsgrades.helpers;

import com.example.komuravellycharan.studnetsgrades.models.Idea;
import java.util.ArrayList;
import java.util.List;

public class SampleContent {

    public static final List<Idea> IDEAS = new ArrayList<Idea>();

    private static int COUNT = 5;

    static {
        // Add some sample items.
        Idea newIdea1 = new Idea();
        newIdea1.setId(1);
        newIdea1.setName("Sai Charan");
        newIdea1.setStatus("4568 1255 6542");
        newIdea1.setDescription("Karimnagar");
        newIdea1.setOwner("505001");
        IDEAS.add(newIdea1);

        Idea newIdea2 = new Idea();
        newIdea2.setId(2);
        newIdea2.setName("Santhosh");
        newIdea2.setStatus("8954 4568 2415");
        newIdea2.setDescription("Suchitra");
        newIdea2.setOwner("500067");
        IDEAS.add(newIdea2);
    }

    public static void createIdea(Idea item) {
        item.setId(COUNT);
        IDEAS.add(item);
        COUNT += 1;
    }

    public static Idea getIdeaById(int id){
        for(int i = 0; i < IDEAS.size(); i++){
            if(IDEAS.get(i).getId() == id){
                return IDEAS.get(i);
            }
        }

        return null;
    }

    public static void deleteIdea(int id){
        Idea ideaToRemove = null;

        for(int i = 0; i < IDEAS.size(); i++){
            if(IDEAS.get(i).getId() == id){
                ideaToRemove = IDEAS.get(i);
            }
        }

        if(ideaToRemove != null){
            IDEAS.remove(ideaToRemove);
        }
    }

    public static void updateIdea(Idea idea){
        for(int i = 0; i < IDEAS.size(); i++){
            if(IDEAS.get(i).getId() == idea.getId()){
                Idea ideaToUpdate = IDEAS.get(i);

                ideaToUpdate.setName(idea.getName());
                ideaToUpdate.setDescription(idea.getDescription());
                ideaToUpdate.setOwner(idea.getOwner());
                ideaToUpdate.setStatus(idea.getStatus());
            }
        }
    }
}
