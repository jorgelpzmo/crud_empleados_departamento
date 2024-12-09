package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOEmpleado {
    DTOEmpleado empleado;
    ArrayList<DTOEmpleado> empleados;
    Connection conexion = null;

    public DAOEmpleado() {
        conexion = DB.getConexion();
        empleados = new ArrayList();
        if (conexion == null) {
            System.out.println("No se puede conectar con la Base de Datos");
        }
    }

    public ArrayList<DTOEmpleado> getEmpleados() {
        try{
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM empleados");
            ResultSet rs = ps.executeQuery();
            empleados = new ArrayList<>();
            while (rs.next()) {
                empleado = new DTOEmpleado(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                empleados.add(empleado);
            }
            return empleados;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public ArrayList<DTOEmpleado> getEmpleadosPorOrden(boolean numero){
        try{
            if(numero) {
                PreparedStatement ps = conexion.prepareStatement("SELECT * FROM empleados ORDER BY DESC");
                ResultSet rs = ps.executeQuery();
                empleados = new ArrayList<>();
                while (rs.next()) {
                    empleado = new DTOEmpleado(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                    empleados.add(empleado);
                }
            }else{
                PreparedStatement ps = conexion.prepareStatement("SELECT * FROM empleados ORDER BY ASC");
                ResultSet rs = ps.executeQuery();
                empleados = new ArrayList<>();
                while (rs.next()) {
                    empleado = new DTOEmpleado(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                    empleados.add(empleado);
                }
            }
            return empleados;
            }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public DTOEmpleado getEmpleado(int id) {
        try{
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM empleados WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empleado = new DTOEmpleado(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
            return empleado;

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int addEmpleado(DTOEmpleado empleado) {
        try{
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO empleados VALUES (?,?,?)");
            ps.setString(1, empleado.getNombre());
            ps.setInt(2, empleado.getEdad());
            ps.setInt(3, empleado.getIdDpto());
            return ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int updateEmpleado(DTOEmpleado empleado) {
        try{
            PreparedStatement ps = conexion.prepareStatement("UPDATE empleados SET nombre =?, edad =?, idDpto =? WHERE id=?");
            PreparedStatement ps2 = conexion.prepareStatement("SELECT id FROM departamento");
            ArrayList numeroDepartamento = new ArrayList();
            ResultSet rs2 =ps2.executeQuery();
            while(rs2.next()){
                numeroDepartamento.add(rs2.getInt(1));
            }
            ps.setString(1, empleado.getNombre());
            ps.setInt(2, empleado.getEdad());
            ps.setInt(3, empleado.getIdDpto());
            if(numeroDepartamento.contains(empleado.getIdDpto())){
                return ps.executeUpdate();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return -1;
    }

    public int deleteEmpleado(int id){
        try{
            PreparedStatement ps = conexion.prepareStatement("DELETE * FROM empleados WHERE id =?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public int deleteAll(){
        try{
            PreparedStatement ps = conexion.prepareStatement("DELETE * FROM empleados");
            return ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
