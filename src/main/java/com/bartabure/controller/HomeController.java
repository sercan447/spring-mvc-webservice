package com.bartabure.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bartabure.model.Personel;


@Controller
@RequestMapping("/personel")
public class HomeController {
	
		static Set<Personel> personeller;
		static {
			personeller = new HashSet<Personel>();
			Personel personel=null;
			for(int i=0;i<10;i++)
			{
				personel = new Personel(i,"personel "+i);
				personeller.add(personel);
			}
		}//static 	
		
	
		// headers="Accept=application/json",produces="application/json"
		
	@RequestMapping(value = "/listele",
			method = RequestMethod.GET 
			,headers="Accept=application/json"
			,produces="application/json")
	@ResponseBody
	public Set<Personel> getPersonelListesi() {
	
		return personeller;
	}
	
	
	@RequestMapping(value="/listele/{numaa}",method=RequestMethod.GET
			/*,headers="Accept=application/json",produces="application/json"*/)
	@ResponseBody
	public Personel getPersontelSingle(@PathVariable("numaa")int numara)
	{
		Personel pers=null;
		Iterator<Personel> ite = personeller.iterator();
		while(ite.hasNext())
		{
			pers = ite.next();
			if(pers.getId() == numara)
			{
				return pers;
			}//if
		}//WHILE
		
		
	return null;
	}
	
	
	@RequestMapping(value="/listele/html.xml",method=RequestMethod.GET
			/*,headers="Accept=text/html",produces="text/html"*/)
	@ResponseBody
	public String getPersontelMulti()
	{
		String htmlkodlari = "<html><body><table border='2'>";
		Personel pers=null;
		Iterator<Personel> ite = personeller.iterator();
		while(ite.hasNext())
		{
			pers = ite.next();
			htmlkodlari += "<tr><td>"+pers.getId()+"</td> <td>"+pers.getAdi()+"</td></tr>";
			
		}//WHILE
		
		htmlkodlari += "</table></body></html>";
	return htmlkodlari;
	}//METHOD
	
	
	@RequestMapping(value="/listele/{numaa}",method=RequestMethod.DELETE
			/*,headers="Accept=application/json",produces="application/json"*/)
	@ResponseBody
	public String getPersontelSIL(@PathVariable("numaa")int numara)
	{
		Personel pers=null;
		Iterator<Personel> ite = personeller.iterator();
		while(ite.hasNext())
		{
			pers = ite.next();
			if(pers.getId() == numara)
			{	
				ite.remove();
				return "SILINDI";
			}//if
		}//WHILE
			
	return "SILINMEDI";
	}
	
	@RequestMapping(value="/listele",method=RequestMethod.POST)
	@ResponseBody
	public boolean EklenmeServisi(@RequestBody Personel personel) {
		
		
		return personeller.add(personel);
	}

	
	
	@RequestMapping(value="/listele/{numaa}",method=RequestMethod.PUT
			/*,headers="Accept=application/json",produces="application/json"*/)
	@ResponseBody
	public String getPersontelEDIT(@RequestBody Personel personel , @PathVariable("numaa")int numara)
	{
		Personel pers=null;
		Iterator<Personel> ite = personeller.iterator();
		while(ite.hasNext())
		{
			pers = ite.next();
			if(pers.getId() == numara)
			{	
				pers.setId(personel.getId());
				pers.setAdi(personel.getAdi());
				return "EDITLENDI";
			}//if
		}//WHILE
			
	return "EDITLENMEDI";
	}
	
	
}
