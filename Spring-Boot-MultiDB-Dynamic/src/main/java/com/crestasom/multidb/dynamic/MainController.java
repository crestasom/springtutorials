package com.crestasom.multidb.dynamic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.multidb.dynamic.model.Advertiser;

@RestController
public class MainController {

	@Autowired
	private DataDAO dataDAO;
	@Autowired
	private AdvertiserDAO advertiserDAO;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Model model) throws SQLException {

		return "home";
	}

	@RequestMapping(value = { "/advertiser/list" }, method = RequestMethod.GET)
	public List<Advertiser> advertiser(Model model) throws SQLException {

		List<Advertiser> list = new ArrayList<>();
		advertiserDAO.findAll().forEach(t -> list.add(t));
		return list;
	}

	@RequestMapping(value = { "/publisher/list" }, method = RequestMethod.GET)
	public List<Advertiser> advertiser1(Model model) throws SQLException {

		List<Advertiser> list = new ArrayList<>();
		advertiserDAO.findAll().forEach(t -> list.add(t));
		return list;
	}

}