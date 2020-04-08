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
		this.mockMvc.perform(get("/ponudas")).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$._embedded.ponudas").isNotEmpty());
	}
	@Test
	public void shouldReturn2ndPonuda() throws Exception {
		this.mockMvc.perform(get("/ponudas/2")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/hal+json;"))
		.andExpect(jsonPath("$").isNotEmpty());
	}
	@Test
	public void givenPonudaPutOrReplaceIntoRepository() throws Exception {
		ObjectMapper om = new ObjectMapper();
	    this.mockMvc.perform(put("/ponudas/1")
	    .content(om.writeValueAsString(new Ponuda(1L, 1L, 250L)))
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print()).andExpect(status().isCreated()) //201 znači da je uspješno kreirano
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.idKatalog").value(1L))
		.andExpect(jsonPath("$.idKorisnik").value(1L))
		.andExpect(jsonPath("$.ponuda").value(250L));
	}
	@Test
	public void givenKatalogPutIntoRepository() throws Exception {
		ObjectMapper om = new ObjectMapper();
	    this.mockMvc.perform(post("/ponudas")
	    .content(om.writeValueAsString(new Ponuda(2L, 2L, 2250L)))
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print()).andExpect(status().isCreated()) //201 znači da je uspješno kreirano
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.idKatalog").value(2L))
		.andExpect(jsonPath("$.idKorisnik").value(2L))
		.andExpect(jsonPath("$.ponuda").value(2250L));
	}
	@Test
	public void givenIdDeleteFromRepository() throws Exception {
	    this.mockMvc.perform(delete("/ponudas/1")
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andExpect(status().isNoContent());  
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