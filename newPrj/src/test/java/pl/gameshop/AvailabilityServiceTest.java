package pl.gameshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.gameshop.models.AvailabilityType;
import pl.gameshop.services.AvailabilityService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class AvailabilityServiceTest {

    @Mock
    private AvailabilityService availabilityService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTypes() {
        Pageable pageable = mock(Pageable.class);
        Page<AvailabilityType> expectedTypes = mock(Page.class);

        when(availabilityService.getAllTypes(pageable)).thenReturn(expectedTypes);

        Page<AvailabilityType> actualTypes = availabilityService.getAllTypes(pageable);

        Assertions.assertEquals(expectedTypes, actualTypes);

        verify(availabilityService, times(1)).getAllTypes(pageable);
        verifyNoMoreInteractions(availabilityService);
    }

    @Test
    public void testGetType() {
        Long typeId = 1L;
        AvailabilityType expectedType = new AvailabilityType();
        expectedType.setId(typeId);

        when(availabilityService.getType(typeId)).thenReturn(expectedType);

        AvailabilityType actualType = availabilityService.getType(typeId);

        Assertions.assertEquals(expectedType, actualType);

        verify(availabilityService, times(1)).getType(typeId);
        verifyNoMoreInteractions(availabilityService);
    }

    @Test
    public void testDeleteType() {
        Long typeId = 1L;

        availabilityService.deleteType(typeId);

        verify(availabilityService, times(1)).deleteType(typeId);
        verifyNoMoreInteractions(availabilityService);
    }

    @Test
    public void testSaveType() {
        AvailabilityType type = new AvailabilityType();
        type.setName("Type 1");

        availabilityService.saveType(type);

        verify(availabilityService, times(1)).saveType(type);
        verifyNoMoreInteractions(availabilityService);
    }

    // Test dla metody getType z argumentem java.lang.Long
    @Test
    public void testGetTypeWithJavaLong() {
        java.lang.Long typeId = java.lang.Long.valueOf(1L);
        AvailabilityType expectedType = new AvailabilityType();
        expectedType.setId(1L);

        when(availabilityService.getType(typeId)).thenReturn(expectedType);

        AvailabilityType actualType = availabilityService.getType(typeId);

        Assertions.assertEquals(expectedType, actualType);

        verify(availabilityService, times(1)).getType(typeId);
        verifyNoMoreInteractions(availabilityService);
    }


    @Test
    public void testDeleteTypeWithJavaLong() {
        java.lang.Long typeId = java.lang.Long.valueOf(1L);

        availabilityService.deleteType(typeId);

        verify(availabilityService, times(1)).deleteType(typeId);
        verifyNoMoreInteractions(availabilityService);
    }





}



