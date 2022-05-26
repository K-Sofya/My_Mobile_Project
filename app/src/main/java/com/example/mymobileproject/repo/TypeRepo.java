package com.example.mymobileproject.repo;

import com.example.mymobileproject.model.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeRepo {

    List<Type> typeList = new ArrayList<>();
    List<Type> fullTypeList = new ArrayList<>();

    public TypeRepo() {
        typeList.add(new Type(1, "canon_eos_r_body", "CANON EOS R BODY", new ProductRepo().getProductByType(1), 1));
        typeList.add(new Type(2, "fujifilm_gfx_50s_body", "FUJIFILM GFX 50S BODY",new ProductRepo().getProductByType(2), 1));
        typeList.add(new Type(3, "canon_eos_r5_body", "CANON EOS R5 BODY", new ProductRepo().getProductByType(3),1));
        typeList.add(new Type(4, "canon_eos_r6_body", "CANON EOS R6 BODY", new ProductRepo().getProductByType(4),1));

        typeList.add(new Type(5, "canon5dmarkivbody", "CANON 5D MARK IV BODY", new ProductRepo().getProductByType(5),2));
        typeList.add(new Type(6, "canon5dmarkiiibody", "CANON 5D MARK III BODY", new ProductRepo().getProductByType(6),2));

        typeList.add(new Type(7, "panasoniceva1ef", "Panasonic EVA1 EF", new ProductRepo().getProductByType(7),3));
        typeList.add(new Type(8, "canonxa15", "CANON XA15", new ProductRepo().getProductByType(8),3));

        typeList.add(new Type(9, "goprohero10blackedition", "GOPRO HERO 10 BLACK EDITION", new ProductRepo().getProductByType(9),4));


        typeList.add(new Type(10, "canonef1124f40lusm", "CANON EF 11-24 f/4.0 L USM", new ProductRepo().getProductByType(10),5));
        typeList.add(new Type(11, "sonysel1018f40oss", "SONY SEL 10-18 f/4.0 OSS", new ProductRepo().getProductByType(11),5));

        typeList.add(new Type(12, "sirui24f28anamorphicmft", "SIRUI 24 f/2.8 ANAMORPHIC MFT", new ProductRepo().getProductByType(12),6));


        typeList.add(new Type(13, "cfexpresstypeb256gbsonyg", "CFEXPRESS TYPE B 256GB SONY G", new ProductRepo().getProductByType(13),7));

        typeList.add(new Type(14, "vmount6a90wh", "V-MOUNT 6А 90WH", new ProductRepo().getProductByType(14),8));


        typeList.add(new Type(15, "canon430exii", "CANON 430EX II", new ProductRepo().getProductByType(15),9));

        typeList.add(new Type(16, "arritruebluet2", "ARRI TRUE BLUE T2", new ProductRepo().getProductByType(16),10));


        fullTypeList.addAll(typeList);
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public List<Type> getTypesBySection(int id){

        List<Type> filterTypes = new ArrayList<>();

        for (Type s: typeList) {
            if(s.getSection() == id) {
                filterTypes.add(s);
            }
        }

        return filterTypes;
    }

}
