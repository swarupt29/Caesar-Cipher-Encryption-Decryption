package com.example.caesarcipher;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaesarCipherController {

    @GetMapping("/encrypt")
    public String encrypt(@RequestParam String text, @RequestParam int shift) {
        return caesarCipher(text, shift);
    }

    @GetMapping("/decrypt")
    public String decrypt(@RequestParam String text, @RequestParam int shift) {
        return caesarCipher(text, -shift);
    }

    private String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base + shift + 26) % 26 + base);
            } else if (Character.isDigit(ch)) {
                char base = '0';
                ch = (char) ((ch - base + shift + 10) % 10 + base);
            }
            result.append(ch);
        }

        return result.toString();
    }
}
