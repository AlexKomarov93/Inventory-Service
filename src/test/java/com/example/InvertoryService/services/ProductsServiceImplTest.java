/*package com.example.InvertoryService.services;


import com.example.InvertoryService.entity.Products;
import com.example.InvertoryService.repos.ProductsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductsServiceImplTest {

    @Mock
    private ProductsRepository productsRepository;

    @InjectMocks
    private ProductsServiceImpl productsService;


    @Test
    @DisplayName("Товар сохраняется корректно")
    void shouldSaveProductCorrectly() {
        //Arrange
        Products product = Products.builder()
                .name("Гвоздь")
                .quantity(1000)
                .price(BigDecimal.valueOf(20.0))
                .sale(BigDecimal.valueOf(14.2))
                .build();

        Products savedProduct = Products.builder()
                .id(1L)
                .name("Гвоздь")
                .quantity(1000)
                .price(BigDecimal.valueOf(20.0))
                .sale(BigDecimal.valueOf(14.2))
                .build();

        when(productsRepository.save(product)).thenReturn(savedProduct);
        //Assert
        Products result = productsService.saveOrUpdate(
                product.getName(),
                product.getQuantity(),
                product.getPrice(),
                product.getSale()
        );
        assertNotNull(result);
        assertEquals(savedProduct.getId(), result.getId());
        verify(productsRepository, times(1)).save(product);
    }

/*
    @Test
    @DisplayName("Товар удаляется корректно")
    void shouldDeleteReminderCorrectly() {
        // Arrange
        doNothing().when(reminderRepository).deleteById(anyLong());
        // ACT
        reminderService.deleteReminder(1L); // Вызываем метод сервиса
        // Assert
        verify(reminderRepository, times(1)).deleteById(anyLong());
    }

    @Test
    @DisplayName("Поиск товара по id")
    void searchReminderByParameters_ShouldCallRepoWithBuiltSpec() {
        String testTitle = "Уборка";
        LocalDate testDate = LocalDate.now();
        LocalTime testTime = LocalTime.now();

        List<Reminder> expectedList = List.of(
                Reminder.builder().id(100L).title("Найдено").build()
        );

        when(reminderRepository.findAll(any(Specification.class))).thenReturn(expectedList);

        List<Reminder> result = reminderService.searchReminderByParameters(testTitle, testDate, testTime);

        assertEquals(expectedList, result);
        verify(reminderRepository, times(1)).findAll(any(Specification.class));
    }

    @Test
    @DisplayName("Получение всего списка товаров")
    void sortByParameters_ShouldCallRepositoryWithSort() {
        Sort sort = Sort.by(Sort.Direction.ASC, "title");

        List<Reminder> expectedList = List.of(
                Reminder.builder().id(1L).title("А").build(),
                Reminder.builder().id(2L).title("Б").build()
        );

        when(reminderRepository.findAll(sort)).thenReturn(expectedList);

        Iterable<Reminder> result = reminderService.sortByParameters(sort);

        assertEquals(expectedList, result);
        verify(reminderRepository, times(1)).findAll(sort);
    }
    //

*/
//}
