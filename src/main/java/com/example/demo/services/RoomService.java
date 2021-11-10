package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Room;
import com.example.demo.repositories.RoomRepository;


@Service
public class RoomService {

		@Autowired
		RoomRepository rrepo;
		
		public List<Room> getByRoom(String status)
		{
			return rrepo.getRoom(status);
		}
		
		public void updateRoomStatus(String status, int rid)
		{
			rrepo.updateRoomStatus(status, rid);
		}
}
