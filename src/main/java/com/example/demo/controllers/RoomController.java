package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Room;
import com.example.demo.services.RoomService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class RoomController {
	
	@Autowired
	RoomService rservice;
	
	@GetMapping("/getbyroom")
	public List<Room> getByRoom(@RequestParam("status") String status)
	{
		return rservice.getByRoom(status);
	}
	
	@PostMapping("/updateroomstatus")
	public void updateRoomStatus(@RequestParam("status") String status, @RequestParam("rid")int rid)
	{
		rservice.updateRoomStatus(status, rid);
	}
}
