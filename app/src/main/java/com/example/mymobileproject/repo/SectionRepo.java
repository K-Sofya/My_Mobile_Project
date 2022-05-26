package com.example.mymobileproject.repo;

import com.example.mymobileproject.model.Section;

import java.util.ArrayList;
import java.util.List;

public class SectionRepo {

    List<Section> sectionList = new ArrayList<>();
    List<Section> fullSectionList = new ArrayList<>();

    public SectionRepo() {
        sectionList.add(new Section(1, "БЕЗЗЕРКАЛЬНЫЕ\nКАМЕРЫ", new TypeRepo().getTypesBySection(1), 1));
        sectionList.add(new Section(2, "ЗЕРКАЛЬНЫЕ\nКАМЕРЫ", new TypeRepo().getTypesBySection(2), 1));
        sectionList.add(new Section(3, "ВИДЕО\nКАМЕРЫ", new TypeRepo().getTypesBySection(3), 1));
        sectionList.add(new Section(4, "ЭКШН\nКАМЕРЫ", new TypeRepo().getTypesBySection(4), 1));

        sectionList.add(new Section(5, "ФОТО И ВИДЕО\nОБЪЕКТИВЫ", new TypeRepo().getTypesBySection(5), 2));
        sectionList.add(new Section(6, "КИНООБЪЕКТИВЫ",new TypeRepo().getTypesBySection(6), 2));

        sectionList.add(new Section(7, "КАРТЫ ПАМЯТИ\nИ ДИСКИ",new TypeRepo().getTypesBySection(7), 3));
        sectionList.add(new Section(8, "АККУМУЛЯТОРЫ\nИ ЗАРЯДКИ",new TypeRepo().getTypesBySection(8), 3));

        sectionList.add(new Section(7, "ИМПУЛЬСНЫЙ\nСВЕТ",new TypeRepo().getTypesBySection(9), 4));
        sectionList.add(new Section(8, "ПРОЖЕКТОРЫ",new TypeRepo().getTypesBySection(10), 4));

        fullSectionList.addAll(sectionList);

    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public List<Section> getSectionsByCategory(int id){

        List<Section> filterSections = new ArrayList<>();

        for (Section s: sectionList) {
            if(s.getCategory() == id) {
                filterSections.add(s);
            }
        }

        return filterSections;
    }

}
