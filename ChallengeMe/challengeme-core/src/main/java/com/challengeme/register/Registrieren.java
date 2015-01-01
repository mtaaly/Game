package com.challengeme.register;

import java.util.HashSet;
import java.util.Set;

import com.challengeme.dao.AnswerDao;
import com.challengeme.dao.KategorieDao;
import com.challengeme.dao.LevelDao;
import com.challengeme.dao.MultipleChoiceDao;
import com.challengeme.dao.SpielDao;
import com.challengeme.dao.UserDao;
import com.challengeme.entities.Answer;
import com.challengeme.entities.Kategorie;
import com.challengeme.entities.Level;
import com.challengeme.entities.MultipleChoice;
import com.challengeme.entities.Spiel;
import com.challengeme.entities.User;

public class Registrieren {

	// QuestionsForQuizDao mC = new QuestionsForQuizDao();

	MultipleChoiceDao mc = new MultipleChoiceDao();
	AnswerDao ad = new AnswerDao();
	KategorieDao kt = new KategorieDao();
	LevelDao ld = new LevelDao();
    UserDao ud = new UserDao();
    SpielDao sd = new SpielDao();
	public static void main(String[] args) {
		// Session session = HibernateConfigurator.getInstance().getSession();
		Registrieren dienst = new Registrieren();
		//dienst.kt.insert("Science");
		
//		dienst.ud.insert("nkemson@tzi.de", "vianney", "vian2");
//		User u1 = dienst.ud.insert("vianney");
		
		
		Level l1 = new Level();
		l1.setLevelName("Einfach");

		Level l2 = new Level();
		l2.setLevelName("Normal");

		Set<Level> levels = new HashSet<Level>();
		levels.add(l1);
		levels.add(l2);
		
		User u1 = new User();
		u1.setName("Vianney");
		u1.setPassword("vian");
		u1.setEmail("nkemson@tzi.de");
		
		Set<User> users = new HashSet<User>();
		users.add(u1);
		
		dienst.sd.insert(levels, users);
		
		Kategorie k1 = new Kategorie();
		k1.setKategorieName("Mathe");

		Kategorie k2 = new Kategorie();
		k2.setKategorieName("Ti2");

		Set<Kategorie> kategories = new HashSet<Kategorie>();
		kategories.add(k1);
		kategories.add(k2);

		dienst.kt.createKategorie("Infos", kategories);
		
		
		Answer a1 = dienst.ad.insert("yaounde");
		Answer a2 = dienst.ad.insert("Douala");
		Answer a3 = dienst.ad.insert("Akonolinga");
		Answer a4 = dienst.ad.insert("Bremen");
			
		String question = new String("In welcher Stadt bist du länger geblieben?");
		MultipleChoice m = dienst.mc.insert(question,a2,a1,a2,a3,a4);
		
		Kategorie k = dienst.kt.insert(k1, m);
		Level level = dienst.ld.insert("normal",m);
		
		/*Spiel spiel = dienst.sd.insert(level);*/
		
		System.exit(0);

	}

}
/*Kategorie k1 = new Kategorie();
k1.setKategorieName("Mathe");

Kategorie k2 = new Kategorie();
k2.setKategorieName("Anglais");

Set<Kategorie> kategories = new HashSet<Kategorie>();
kategories.add(k1);
kategories.add(k2);

dienst.kt.createKategorie("cm2", kategories);




Answer a1 = dienst.ad.insert("yaounde");
Answer a2 = dienst.ad.insert("Douala");
Answer a3 = dienst.ad.insert("Akonolinga");
Answer a4 = dienst.ad.insert("Bremen");



String question = new String("In welcher Stadt bist du länger geblieben?");
MultipleChoice m = dienst.mc.insert(question,a2,a1,a2,a3,a4);


Kategorie k = dienst.kt.insert(k1, m);
dienst.ld.insert("einfach",m);
dienst.ld.updateLevel(1, "schwer");
//dienst.mc.delete(1);
dienst.ld.delete(1);*/
