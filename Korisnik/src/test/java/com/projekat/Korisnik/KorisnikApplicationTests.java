package com.projekat.Korisnik;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projekat.Korisnik.model.Korisnik;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.json.JSONObject;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@SpringBootTest
@AutoConfigureMockMvc
class KorisnikApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnKorisnici() throws Exception {
		this.mockMvc.perform(get("/korisnici")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$").isNotEmpty());
	}
	@Test
	public void shouldReturn5thKorisnik() throws Exception {
		this.mockMvc.perform(get("/korisnici/korisnikSaId?id=5")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.firstName").value("Michelle"))
		.andExpect(jsonPath("$.lastName").value("Dessler"))
		.andExpect(jsonPath("$.location").value("Visoko"))
		.andExpect(jsonPath("$.email").value("Iomanovic1@etf.unsa.ba"))
		.andExpect(jsonPath("$.phone").value("062/111-111"))
		.andExpect(jsonPath("$.id").value("5"));
	}
	@Test
	public void givenKorisnikPutIntoRepository() throws Exception {
		ObjectMapper om = new ObjectMapper();
	    this.mockMvc.perform(post("/korisnici")
	    .content(om.writeValueAsString(new Korisnik("Amir", "Sijah", "Travnik", "asijah1@etf.unsa.ba", "062/111-111")))
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print()).andExpect(status().is(200)) //201 znači da je uspješno kreirano
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.firstName").value("Amir"))
		.andExpect(jsonPath("$.lastName").value("Sijah"))
		.andExpect(jsonPath("$.location").value("Travnik"))
		.andExpect(jsonPath("$.email").value("asijah1@etf.unsa.ba"))
		.andExpect(jsonPath("$.phone").value("062/111-111"));
	}
	@Test
	public void givenKorisnikReplaceOrPutIntoRepository() throws Exception {
		ObjectMapper om = new ObjectMapper();
	    this.mockMvc.perform(put("/korisnici?id=1")
	    .content(om.writeValueAsString(new Korisnik("Ferhad", "Mesic", "Cazin", "fmesic1@etf.unsa.ba", "062/111-111")))
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print()).andExpect(status().isOk()) //201 znači da je uspješno kreirano
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.firstName").value("Ferhad"))
		.andExpect(jsonPath("$.lastName").value("Mesic"))
		.andExpect(jsonPath("$.location").value("Cazin"))
		.andExpect(jsonPath("$.email").value("fmesic1@etf.unsa.ba"))
		.andExpect(jsonPath("$.phone").value("062/111-111"))
		.andExpect(jsonPath("$.id").value("1"));
	}
	@Test
	public void shouldReturnFirstNameKim() throws Exception {
		this.mockMvc.perform(get("/korisnici/ime?firstName=Kim")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;"))
		.andExpect(jsonPath("$.firstName").value("Kim")); 
	}
	@Test
	public void shouldReturnLastNameBauer() throws Exception {
		this.mockMvc.perform(get("/korisnici/prezime?lastName=Bauer")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;"))
		.andExpect(jsonPath("$.lastName").value("Bauer")); 
	}
	@Test
	public void givenIdDeleteFromRepository() throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("id", 1);
	    this.mockMvc.perform(delete("/korisnici")
	    .content(jo.toString())
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk());  
	}
	/*
	@Test
	public void shouldDeleteFirstWhichIsBauer() throws Exception {
		this.mockMvc.perform(delete("/korisnici/1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/hal+json;"))
		.andExpect(jsonPath("$._embedded.korisnici.[0].lastName").value("Bauer")); 
	}
	*/
}

//public class GreetControllerIntegrationTest {
  //  ....
//}