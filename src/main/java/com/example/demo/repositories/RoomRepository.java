package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Room;

@Repository
@Transactional
public interface RoomRepository extends JpaRepository<Room, Integer> {
	
	@Query("select r from Room r where status = ?1")
	public List<Room> getRoom(String status);
	
	
	//update room status by searching by rid
	@Modifying
	@Query("update Room r set r.status=:status where r.rid=:rid")
	public void updateRoomStatus(String status, int rid);
	
}

