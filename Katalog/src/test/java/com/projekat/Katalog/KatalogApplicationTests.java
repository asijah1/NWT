package com.projekat.Katalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projekat.Katalog.model.Katalog;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@SpringBootTest
@AutoConfigureMockMvc
class KatalogApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnKatalozi() throws Exception {
		this.mockMvc.perform(get("/katalogs")).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$._embedded.katalogs").isNotEmpty());
	}
	@Test
	public void shouldReturn5thKatalog() throws Exception {
		this.mockMvc.perform(get("/katalogs/5")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/hal+json;"))
		.andExpect(jsonPath("$").isNotEmpty());
	}
	@Test
	public void givenKatalogPutOrReplaceIntoRepository() throws Exception {
		ObjectMapper om = new ObjectMapper();
	    this.mockMvc.perform(put("/katalogs/1")
	    .content(om.writeValueAsString(new Katalog("RX570", "Grafička kartica", 250, null,
				null, 2L, 1L, true)))
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print()).andExpect(status().isCreated()) //201 znači da je uspješno kreirano
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.nazivProizvoda").value("RX570"))
		.andExpect(jsonPath("$.dodatneInformacije").value("Grafička kartica"))
		.andExpect(jsonPath("$.cijena").value(250))
		.andExpect(jsonPath("$.zavrseno").value(true));
	}
	@Test
	public void givenKorisnikPutIntoRepository() throws Exception {
		ObjectMapper om = new ObjectMapper();
	    this.mockMvc.perform(post("/katalogs")
	    .content(om.writeValueAsString(new Katalog("RX580", "Grafička kartica", 350, null,
				null, 2L, 1L, true)))
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
	    .andDo(print()).andExpect(status().isCreated()) //201 znači da je uspješno kreirano
	    .andExpect(content().contentType("application/json;"))
	    .andExpect(jsonPath("$.nazivProizvoda").value("RX580"))
		.andExpect(jsonPath("$.dodatneInformacije").value("Grafička kartica"))
		.andExpect(jsonPath("$.cijena").value(350))
		.andExpect(jsonPath("$.zavrseno").value(true));
	}
	@Test
	public void givenIdDeleteFromRepository() throws Exception {
	    this.mockMvc.perform(delete("/katalogs/1")
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