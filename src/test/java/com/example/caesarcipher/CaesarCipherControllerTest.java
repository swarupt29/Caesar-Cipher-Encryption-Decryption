package com.example.caesarcipher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CaesarCipherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testEncrypt() throws Exception {
        mockMvc.perform(get("/encrypt")
                .param("text", "hello")
                .param("shift", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("khoor"));
    }

    @Test
    public void testDecrypt() throws Exception {
        mockMvc.perform(get("/decrypt")
                .param("text", "khoor")
                .param("shift", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void testEncryptWithWrapAround() throws Exception {
        mockMvc.perform(get("/encrypt")
                .param("text", "xyz")
                .param("shift", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("abc"));
    }

    @Test
    public void testDecryptWithWrapAround() throws Exception {
        mockMvc.perform(get("/decrypt")
                .param("text", "abc")
                .param("shift", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("xyz"));
    }

    @Test
    public void testEncryptWithMixedCase() throws Exception {
        mockMvc.perform(get("/encrypt")
                .param("text", "HelloWorld")
                .param("shift", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("MjqqtBtwqi"));
    }

    @Test
    public void testDecryptWithMixedCase() throws Exception {
        mockMvc.perform(get("/decrypt")
                .param("text", "MjqqtBtwqi")
                .param("shift", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("HelloWorld"));
    }

    @Test
    public void testEncryptWithNegativeShift() throws Exception {
        mockMvc.perform(get("/encrypt")
                .param("text", "hello")
                .param("shift", "-3"))
                .andExpect(status().isOk())
                .andExpect(content().string("ebiil"));
    }

    @Test
    public void testDecryptWithNegativeShift() throws Exception {
        mockMvc.perform(get("/decrypt")
                .param("text", "ebiil")
                .param("shift", "-3"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }
}
