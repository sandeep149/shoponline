package net.sandy.shopebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import net.sandy.shopebackend.dao.CategoryDAO;
import net.sandy.shopebackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.sandy.shopebackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	@Test
	public void testCRUDCategory() {

		category = new Category();

		category.setName("Laptop");
		category.setDescription("this is apple laptop");
		category.setImageURL("a1.png");
		assertEquals("succefull add the category", true, categoryDAO.add(category));

		category.setName("TV");
		category.setDescription("this is samsung tv");
		category.setImageURL("A2.png");
		assertEquals("succefull add the category", true, categoryDAO.add(category));

		// fetching and updating the category
		category = categoryDAO.get(3);

		category.setName("TV");

		assertEquals("succefull update  category from the table", true, categoryDAO.update(category));

		// delete the query

		assertEquals("succefull deleted  category from the table", true, categoryDAO.delete(category));
		// fetching the list
		assertEquals("succefull fatched the list of categories from the table", 1, categoryDAO.list().size());

	}

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * assertEquals("succefull fatched a single category from the table", "Mobile",
	 * category.getName());
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void testAddCategory(){ category = new Category();
	 * category.setName("TV"); category.setDescription("this is samsung tv");
	 * category.setImageURL("1.png");
	 * 
	 * assertEquals("succefull add the category", true, categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * category.setName("TV");
	 * 
	 * assertEquals("succefull update  category from the table", true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testdeleteCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * assertEquals("succefull deleted  category from the table", true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("succefull fatched the list of categories from the table", 3,
	 * categoryDAO.list().size());
	 * 
	 * 
	 * }
	 */

}
