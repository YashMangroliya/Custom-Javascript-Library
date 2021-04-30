package com.thinking.machines.hr.dl;
import java.sql.*;
public class AdministratorDAO 
{
public AdministratorDTO getByUsername(String username) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from administrator where uname=?");
preparedStatement.setString(1,username);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(!resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Username "+username+" does not exist.");
}
AdministratorDTO administratorDTO=new AdministratorDTO();
administratorDTO.setUsername(username);
administratorDTO.setPassword(resultSet.getString("pwd").trim());
resultSet.close();
preparedStatement.close();
connection.close();
return administratorDTO;
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
}
