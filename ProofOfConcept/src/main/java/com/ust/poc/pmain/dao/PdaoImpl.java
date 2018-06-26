package com.ust.poc.pmain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.ust.poc.pmain.model.Pmodel;

@Repository
public class PdaoImpl implements Pdao {

	@Autowired
	MongoOperations mongoOperations;

	public MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	public void setMongoOperations(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	MongoClient mongo = new MongoClient("localhost", 27017);
	@SuppressWarnings("deprecation")
	DB db = mongo.getDB("test");
	DBCollection table = db.getCollection("pmodel");

	@Override
	public String addP(Pmodel pmodel) {

		BasicDBObject document = new BasicDBObject();
		document.put("id", pmodel.getId());
		document.put("name", pmodel.getName());
		document.put("age", pmodel.getAge());
		document.put("place", pmodel.getPlace());
		document.put("job", pmodel.getJob());
		table.insert(document);
		return "Successfully added";
	}

	@Override
	public List<DBObject> diplayPersons() {

		List<DBObject> dbObjects = table.find().toArray();
		
		for (DBObject dbObject : dbObjects) {
			System.out.println(dbObject.get("name"));
			System.out.println(dbObject.get("age"));
			//System.out.println(dbObject);
		}
		// String str="";
		// while (cursor.hasNext()) {
		// str+= cursor.next().tostring;
		// }
		return dbObjects;
	}

	@Override
	public String deletePer(int id) {

		BasicDBObject deleteQuery = new BasicDBObject();
		deleteQuery.put("id", id);
		DBCursor cursor = table.find(deleteQuery);
		if (cursor.hasNext()) {
			DBObject item = cursor.next();
			table.remove(item);
			return "deleted successfully";
		} else {
			return " No id Exist with: " + id + "";
		}
	}

	@Override
	public String updatePer(Pmodel pmodel) {

		BasicDBObject query = new BasicDBObject();
		query.put("id", pmodel.getId());

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("name", pmodel.getName());

		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);

		table.update(query, updateObj);
		return "Updated successfully";
	}

	@Override
	public String getPerson(int id) {

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("id", id);

		// DBObject data=table.findOne(whereQuery);
		// System.out.println(data);

		DBCursor cursor3 = table.find(whereQuery);
		if (cursor3.hasNext()) {
			String string = cursor3.next().toString();
			return string;
		} else {
			return "No id found with: " + id + "";
		}
	}

	@Override
	public String addservice() {

		// Pmodel pmodel=new Pmodel(521, "b", 11, "v", "b");

		BasicDBObject object = new BasicDBObject();
		object.put("id", 121);
		object.put("name", "basil");
		object.put("age", 22);
		object.put("place", "vazhakala");
		object.put("job", "graduate");
		table.save(object);

		// mongoOperations.save(pmodel1);
		// mongoOperations.insert(pmodel1, "Pmodel");
		// mongoOperations.save(pmodel1, "pmodel");
		// mongoOperations.insert(pmodel1, collection);

		return "success!";
	}
}