package com.example.petshop;

import com.example.petshop.models.Category;
import com.example.petshop.models.Pet;
import com.example.petshop.models.Product;
import com.example.petshop.repositories.CategoryRepository;
import com.example.petshop.repositories.PetsRepository;
import com.example.petshop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private PetsRepository petsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        Category category1 = new Category();
        category1.setName("Voeding");
        Category category2 = new Category();
        category2.setName("Kooien");
        Pet pet = new Pet();
        pet.setName("Kat");
        pet.setCategories(Arrays.asList(category1, category2));
        Pet pet2 = new Pet();
        pet2.setName("Hond");
        pet2.setCategories(Arrays.asList(category1, category2));
        Pet pet3 = new Pet();
        pet3.setName("Knaagdier");
        pet3.setCategories(Arrays.asList(category1, category2));
        Pet pet4 = new Pet();
        pet4.setName("Vogel");
        pet4.setCategories(Arrays.asList(category1, category2));
        Product prod1 = new Product();
        Product prod2 = new Product();
        prod1.setName("Defu Paté 16x100g Rundvlees");
        prod1.setImage("https://media.os.fressnapf.com/products/img/1217022/1217022_8817684666069.jpg?t=prod_s");
        prod1.setPrice(16.99);
        prod1.setDescription("Biologische premium complete voeding voor volwassen katten. Alle ingrediënten komen uit Duitsland en rechtstreeks van de biologische boer met een bijzonder hoog vleesgehalte.\n" +
                "\n" +
                "Biologisch premium volwaardig voer voor volwassen katten.\n" +
                "\n" +
                "De ingrediënten van Defu komen allemaal uit Duitsland en strikt biologische landbouw - in voedselkwaliteit.\n" +
                "\n" +
                "Defu heeft een vleesgehalte van 96%. Bovendien is het voedsel verfijnd met de wortel van de Lichtyams, dit is een traditioneel Chinees geneesmiddel en is altijd gewaardeerd om zijn ontstekingsremmende werking.\n" +
                "\n" +
                "Omdat Defu Organic Premium Whole Food gemaakt is zonder granen, is het ideaal als dagelijkse voeding voor katten die gevoelig zijn voor allergieën.\n" +
                "\n" +
                "Andere voordelen in een oogopslag:\n" +
                "-100% organisch premium volwaardig voedsel.\n" +
                "-96% vleesgehalte\n" +
                "-Granen- en glutenvrij met de wortel van de Lichtyams (Chinese geneeskrachtige plant, die een ontstekingsremmende werking kan hebben).\n" +
                "-vrij van kunstmatige smaakstoffen, kleurstoffen en conserveringsmiddelen\n" +
                "-Maak in Duitsland");
        prod1.setCategory(category1);
        prod1.setPet(pet);
        prod2.setName("Dogs Love Dog's Love Adult Vegan BIO BARF 6 x 400 g Greens");
        prod2.setImage("https://media.os.fressnapf.com/products/img/1274545/1274545_8837776430805.jpg?t=prod_s");
        prod2.setDescription("Veganistische groente- en fruitmix in 100% biologische voedselkwaliteit van alle grondstoffen.\n" +
                "Verse groenten en fruit in de ideale verhouding tot elkaar als aanvulling op de DOG'S LOVE BARF-soorten of rauw vlees.\n" +
                "\n" +
                "De Dog´s  LoveBio Vegan met groenten en fruit   bevat veel verse groenten en fruit, die in een uitgebalanceerde verhouding zijn om de vleesvoeding optimaal aan te vullen.\n" +
                "\n" +
                "De aanwezige mineralen en minerale aarde helpen ook aan de mineralenbehoefte van de hond te voldoen.");
        prod2.setPrice(15.90);
        prod2.setCategory(category1);
        prod2.setPet(pet2);

        if (categoryRepository.count() == 0) {
            categoryRepository.save(category1);
            categoryRepository.save(category2);
        }

        if (petsRepository.count() == 0) {
            petsRepository.save(pet);
            petsRepository.save(pet2);
            petsRepository.save(pet3);
            petsRepository.save(pet4);
        }


        if (productsRepository.count() == 0) {
            productsRepository.save(prod1);
            productsRepository.save(prod2);
        }
    }
}