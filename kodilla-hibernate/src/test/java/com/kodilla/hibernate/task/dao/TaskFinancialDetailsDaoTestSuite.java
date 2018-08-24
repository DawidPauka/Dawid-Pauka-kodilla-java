package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        johnSmith.getCompanies().add(softwareMachine);
        dataMaesters.getEmployees().add(stephanieClarckson);
        stephanieClarckson.getCompanies().add(dataMaesters);
        dataMaesters.getEmployees().add(lindaKovalsky);
        lindaKovalsky.getCompanies().add(dataMaesters);
        greyMatter.getEmployees().add(johnSmith);
        johnSmith.getCompanies().add(greyMatter);
        greyMatter.getEmployees().add(lindaKovalsky);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testRetrieveCompaniesWithNamePrefix() {
        // Given
        final String prefix3Chars = "Car";
        final String prefixCompanyCName = "Carmen";
        final String prefixCompanyCNamePlus = "Carmenx";
        final String prefixEmpty = "";

        // name suffixes A,B,C,... mirror sorting by name
        Company ignoredCompanyA = new Company("BMW Group");
        Company searchedCompanyB = new Company("Carafe @ Bottle");
        Company searchedCompanyC = new Company("Carmen");
        Company searchedCompanyD = new Company("Cars Warehouse");
        Company ignoredCompanyE = new Company("Daimler AG");
        Company ignoredCompanyF = new Company("General Motors");



        Employee employee1 = new Employee("Jan", "Kowalski");
        Employee employee2 = new Employee("Andrzej", "Nowak");
        Employee employee3 = new Employee("Kamil", "Kowalski");
        Employee employee4 = new Employee("Cyprian", "Zetowski");
        Employee employee5 = new Employee("Jacek", "Kowalski");

        associate(searchedCompanyB, employee1);
        associate(searchedCompanyB, employee2);
        associate(searchedCompanyC, employee3);
        associate(searchedCompanyC, employee4);
        associate(searchedCompanyD, employee5);
        associate(ignoredCompanyA, employee5);
        associate(ignoredCompanyE, employee5);
        associate(ignoredCompanyF, employee5);

        List<Integer> ids = new ArrayList<>();
        ids.add(companyDao.save(searchedCompanyB).getId());
        ids.add(companyDao.save(ignoredCompanyA).getId());
        ids.add(companyDao.save(searchedCompanyC).getId());
        ids.add(companyDao.save(ignoredCompanyE).getId());
        ids.add(companyDao.save(searchedCompanyD).getId());
        ids.add(companyDao.save(ignoredCompanyF).getId());

        // When & then
        try {
            assertEquals(Arrays.asList(searchedCompanyB, searchedCompanyC, searchedCompanyD),
                    companyDao.retrieveCompaniesWithNamePrefix(prefix3Chars));
            assertEquals(Arrays.asList(searchedCompanyC),
                    companyDao.retrieveCompaniesWithNamePrefix(prefixCompanyCName));
            assertEquals(Collections.emptyList(),
                    companyDao.retrieveCompaniesWithNamePrefix(prefixCompanyCNamePlus));
            assertEquals(Arrays.asList(ignoredCompanyA, searchedCompanyB, searchedCompanyC, searchedCompanyD,
                    ignoredCompanyE, ignoredCompanyF),
                    companyDao.retrieveCompaniesWithNamePrefix(prefixEmpty));

        } finally {
            //CleanUp
            for(int id : ids) {
                try {
                    companyDao.delete(id);
                } catch (Exception exc) {
                    log.warning("CleanUp: " + exc);
                }
            }
        }
    }

    @Test
    public void testRetrieveEmployeesWithLastName() {
        // Given
        final String searchedName = "Kowalski";
        final String searchedNameFragment = "Kowalsk";
        final String searchedNamePlus = "Kowalskix";
        final String searchedNameEmpty = "";

        // name suffixes A,B,C mirror sorting by (lastname, firstname)
        Employee searchedEmployeeA = new Employee("Jacek", "Kowalski");
        Employee searchedEmployeeB = new Employee("Jan", "Kowalski");
        Employee searchedEmployeeC = new Employee("Kamil", "Kowalski");

        Employee ignoredEmployee1 = new Employee("Andrzej", "Nowak");
        Employee ignoredEmployee2 = new Employee("Cyprian", "Zetowski");

        Company company1 = new Company("Daimler AG");
        Company company2 = new Company("BMW Group");

        associate(company1, searchedEmployeeA);
        associate(company1, ignoredEmployee1);
        associate(company1, searchedEmployeeB);
        associate(company2, ignoredEmployee2);
        associate(company2, searchedEmployeeC);

        List<Integer> ids = new ArrayList<>();
        ids.add(companyDao.save(company1).getId());
        ids.add(companyDao.save(company2).getId());

        // When & Then
        try {
            assertEquals(Arrays.asList(searchedEmployeeA, searchedEmployeeB, searchedEmployeeC),
                    employeeDao.retrieveEmployeesWithLastName(searchedName));
            assertEquals(Collections.emptyList(), employeeDao.retrieveEmployeesWithLastName(searchedNameFragment));
            assertEquals(Collections.emptyList(), employeeDao.retrieveEmployeesWithLastName(searchedNamePlus));
            assertEquals(Collections.emptyList(), employeeDao.retrieveEmployeesWithLastName(searchedNameEmpty));
        } finally {
            //CleanUp
            for(int id : ids) {
                try {
                    companyDao.delete(id);
                } catch (Exception exc) {
                    System.err.println("CleanUp: " + exc);
                }
            }
        }

    }

    private void associate(Company c, Employee e) {
        assertNotNull(c);
        assertNotNull(e);
        e.getCompanies().add(c);
        c.getEmployees().add(e);
    }
}