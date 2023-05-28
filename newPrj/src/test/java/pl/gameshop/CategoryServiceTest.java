
package pl.gameshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.gameshop.models.Category;
import pl.gameshop.models.Product;
import pl.gameshop.services.CategoryService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class CategoryServiceTest {

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void testGetAllCategories() {
        Pageable pageable = mock(Pageable.class);
        Page<Category> expectedCategories = mock(Page.class);

        when(categoryService.getAllCategories(pageable)).thenReturn(expectedCategories);

        Page<Category> actualCategories = categoryService.getAllCategories(pageable);

        Assertions.assertEquals(expectedCategories, actualCategories);

        verify(categoryService, times(1)).getAllCategories(pageable);
        verifyNoMoreInteractions(categoryService);
    }

    @Test
    public void testGetCategory() {
        Long categoryId = 1L;
        Category expectedCategory = new Category();
        expectedCategory.setId(categoryId);

        when(categoryService.getCategory(categoryId)).thenReturn(expectedCategory);

        Category actualCategory = categoryService.getCategory(categoryId);

        Assertions.assertEquals(expectedCategory, actualCategory);

        verify(categoryService, times(1)).getCategory(categoryId);
        verifyNoMoreInteractions(categoryService);
    }

    // Podobnie można napisać testy dla pozostałych metod...

    @Test
    public void testDeleteCategory() {
        Long categoryId = 1L;

        categoryService.deleteCategory(categoryId);

        verify(categoryService, times(1)).deleteCategory(categoryId);
        verifyNoMoreInteractions(categoryService);
    }

    @Test
    public void testSaveCategory() {
        Category category = new Category();
        category.setName("Category 1");

        categoryService.saveCategory(category);

        verify(categoryService, times(1)).saveCategory(category);
        verifyNoMoreInteractions(categoryService);
    }



}



