package com.projekat.Ponuda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projekat.Ponuda.model.Ponuda;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@AutoConfigureMockMvc
@SpringBootTest
class PonudaApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnPonude() throws Exception {
		this.mockMvc.perform(get("/ponude")).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$").isNotEmpty())
		.andExpect(jsonPath("$").isArray());
	}
	@Test
	public void shouldReturn2ndPonuda() throws Exception {
		this.mockMvc.perform(get("/ponude/ponudaSaId?id=2")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;"))
		.andExpect(jsonPath("$.id").value("2"));
	}
	@Test
	public void givenPonudaPutOrReplaceIntoRepository() throws Exception {
		ObjectMapper om = new ObjectMapper();
	    this.mockMvc.perform(put("/ponude?id=3")
	    .content(om.writeValueAsString(new Ponuda(1L, 1L, 250L)))
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print()).andExpect(status().isOk()) //201 znači da je uspješno kreirano
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.idKatalog").value(1L))
		.andExpect(jsonPath("$.idKorisnik").value(1L))
		.andExpect(jsonPath("$.ponuda").value(250L))
		.andExpect(jsonPath("$.id").value("3"));
	}
	@Test
	public void givenKatalogPutIntoRepository() throws Exception {
		ObjectMapper om = new ObjectMapper();
	    this.mockMvc.perform(post("/ponude")
	    .content(om.writeValueAsString(new Ponuda(2L, 2L, 2250L)))
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print()).andExpect(status().isOk()) //201 znači da je uspješno kreirano
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.idKatalog").value(2L))
		.andExpect(jsonPath("$.idKorisnik").value(2L))
		.andExpect(jsonPath("$.ponuda").value(2250L));
	}
	@Test
	public void givenIdDeleteFromRepository() throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("id", 1);
	    this.mockMvc.perform(delete("/ponude")
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