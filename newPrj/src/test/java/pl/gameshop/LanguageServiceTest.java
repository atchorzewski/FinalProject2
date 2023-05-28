
package pl.gameshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.gameshop.models.Language;
import pl.gameshop.services.LanguageService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class LanguageServiceTest {

    @Mock
    private LanguageService languageService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllLanguages() {
        Pageable pageable = mock(Pageable.class);
        Page<Language> expectedLanguages = mock(Page.class);

        when(languageService.getAllLanguages(pageable)).thenReturn(expectedLanguages);

        Page<Language> actualLanguages = languageService.getAllLanguages(pageable);

        Assertions.assertEquals(expectedLanguages, actualLanguages);

        verify(languageService, times(1)).getAllLanguages(pageable);
        verifyNoMoreInteractions(languageService);
    }

    @Test
    public void testGetLanguage() {
        Long languageId = 1L;
        Language expectedLanguage = new Language();
        expectedLanguage.setId(languageId);

        when(languageService.getLanguage(languageId)).thenReturn(expectedLanguage);

        Language actualLanguage = languageService.getLanguage(languageId);

        Assertions.assertEquals(expectedLanguage, actualLanguage);

        verify(languageService, times(1)).getLanguage(languageId);
        verifyNoMoreInteractions(languageService);
    }

    @Test
    public void testDeleteLanguage() {
        Long languageId = 1L;

        languageService.deleteLanguage(languageId);

        verify(languageService, times(1)).deleteLanguage(languageId);
        verifyNoMoreInteractions(languageService);
    }

    @Test
    public void testSaveLanguage() {
        Language language = new Language();
        language.setName("English");

        languageService.saveLanguage(language);

        verify(languageService, times(1)).saveLanguage(language);
        verifyNoMoreInteractions(languageService);
    }



}



