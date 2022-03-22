package com.qa.jdbc.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qa.jdbc.domain.Items;

public class ItemsDAO implements Dao<Items>{

	@Override
	public void create(Items t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Items readById(int id) {
		// TODO Auto-generated method stub
		return null;
	} // these are my test notes

	@Override
	public List<Items> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Items t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Items modelFromResultsSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
