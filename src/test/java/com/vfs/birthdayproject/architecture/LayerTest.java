package com.vfs.birthdayproject.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.core.importer.ImportOption.Predefined.DO_NOT_INCLUDE_TESTS;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;


public class LayerTest {
    private JavaClasses javaClasses;

    @BeforeEach
    public void init() {
        javaClasses = new ClassFileImporter()
                .withImportOption(DO_NOT_INCLUDE_TESTS)
                .importPackages("com.vfs.birthdayproject");
    }

    @Test
    public void givenDomainLayerThenDoesNotDependsFromAdapterLayerAndInfrastructure() {
        ArchRule domainLayer = noClasses()
                .that().resideInAPackage("..domain..")
                .should().dependOnClassesThat().resideInAPackage("..adapter..")
                .orShould().dependOnClassesThat().resideInAPackage("..infrastructure..");
        domainLayer.check(javaClasses);
    }

    @Test
    public void givenInAdapterLayerThenDoesNotDependsFromOutAdapter() {
        ArchRule adapterInLayer = noClasses().that().resideInAPackage("..adapter.in..")
                .should().dependOnClassesThat().resideInAPackage("..adapter.out..");
        adapterInLayer.check(javaClasses);
    }

    @Test
    public void givenOutAdapterLayerThenDoesNotDependsFromInAdapter() {
        ArchRule adapterInLayer = noClasses().that().resideInAPackage("..adapter.out..")
                .should().dependOnClassesThat().resideInAPackage("..adapter.in..");
        adapterInLayer.check(javaClasses);
    }
}
