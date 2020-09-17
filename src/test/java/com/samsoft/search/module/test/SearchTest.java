package com.samsoft.search.module.test;

import com.samsoft.search.module.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.base.BaseTest;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.gotoVideos();
        int size = searchPage.getResult();
        Assert.assertTrue(size > 0);
    }

}
