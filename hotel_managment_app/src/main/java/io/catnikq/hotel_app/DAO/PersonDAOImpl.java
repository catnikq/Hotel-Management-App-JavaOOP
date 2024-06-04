package io.catnikq.hotel_app.DAO;

import io.catnikq.hotel_app.Database;
import io.catnikq.hotel_app.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    @Override
    public Person get(int id) throws SQLException {
        Connection con = Database.getConnection();
        Person person = null;
        
        String sql = "SELECT id, name, address, phone_number, age, gender FROM person WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
			int oid = rs.getInt("id");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String phone_number = rs.getString("phone_number");
                        int age = rs.getInt("age");
                        String gender =rs.getString("gender");

			person = new Person(oid, name, address, phone_number, age, gender);
		}

	Database.closeResultSet(rs);
	Database.closePreparedStatement(ps);
        Database.closeConnection(con);
        return person;
    }

    @Override
    public List<Person> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Person person) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Person person) throws SQLException {
        return 0;
    }

    @Override
    public int update(Person person) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Person person) {
        return 0;
    }
    
}
