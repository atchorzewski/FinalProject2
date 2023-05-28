
package pl.gameshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.gameshop.repositories.ProductRepository;
import pl.gameshop.services.ProductService;
import pl.gameshop.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.gameshop.controllers.commands.ProductFilter;
import pl.gameshop.models.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        ProductFilter filter = new ProductFilter();
        Pageable pageable = mock(Pageable.class);
        Page<Product> expectedProducts = mock(Page.class);

        when(productService.getAllProducts(filter, pageable)).thenReturn(expectedProducts);

        Page<Product> actualProducts = productService.getAllProducts(filter, pageable);

        Assertions.assertEquals(expectedProducts, actualProducts);

        verify(productService, times(1)).getAllProducts(filter, pageable);
        verifyNoMoreInteractions(productService);
    }


}