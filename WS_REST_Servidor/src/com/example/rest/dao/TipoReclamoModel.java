package com.example.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.example.rest.entidades.TipoReclamo;
import com.example.rest.util.MySqlDBConexion;

public class TipoReclamoModel {

	
	private static final Log log = LogFactory.getLog(TipoReclamoModel.class);
	
	public List<TipoReclamo> listartiporeclamoTodos() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<TipoReclamo> lista = new ArrayList<TipoReclamo>();
		try {
			String sql = "select * from tiporeclamo";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			TipoReclamo bean = null;
			while(rs.next()){
				bean = new TipoReclamo();
				bean.setIdtipoReclamo(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setEstado(rs.getString(3));
				bean.setFechaRegistro(rs.getString(4));
				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}

	
	public int insertaTipoReclamo(TipoReclamo obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into tiporeclamo values(null,?,?,?)";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setString(2, obj.getEstado());
			pstm.setString(3, obj.getFechaRegistro());
			log.info(pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	
	public int actualizaTipoReclamo(TipoReclamo obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update tiporeclamo set descripcion =?, estado =?, fechaRegistro=? where idtipoReclamo =? ";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setString(2, obj.getEstado());
			pstm.setString(3, obj.getFechaRegistro());
			pstm.setInt(3, obj.getIdtipoReclamo());
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	
	
	public int eliminaTipoReclamo(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from tiporeclamo where idtipoReclamo =?";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			log.info(pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

}
