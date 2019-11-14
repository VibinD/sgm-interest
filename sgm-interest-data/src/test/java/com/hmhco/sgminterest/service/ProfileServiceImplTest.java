package com.hmhco.sgminterest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hmhco.sgminterest.domain.Profile;
import com.hmhco.sgminterest.persistence.ProfileRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileServiceImplTest {
	
	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	private ProfileService profileService;
	
	List<String> keywords = null;
	
	@Before
	public void setup() {
		keywords = new ArrayList<String>();
		keywords.add("late");
		keywords.add("Sixties");
		Profile profile = new Profile(4, "Curtis Mayfield", "artist", "If, in the late Fifties and early Sixties, you were drawn to that place on the AM radio dial where the rhythms, the grooves and the beautiful sounds of African-American soul were playing, you would have found Curtis Mayfield. Many of us first heard him as backing vocalist in the Impressions behind Jerry Butler, singing \"For Your Precious Love.\" But he really came into focus in Butler's next big hit, \"He Will Break Your Heart,\" which was written by Mayfield and features his strumming electric guitar to a saucy tango beat that you can hear echoing in Ben E. King's \"Spanish Harlem\".", "painting");
		profileRepository.save(profile);
		
	}
	
	@Test
	public void testGetProfilesByCategoryAndSubCategory() {
		String category = "artist";
		String subCategory = "painting";
		List<Profile> profiles = profileService.getProfilesByCategoryAndSubCategory(category, subCategory);
		assertNotNull(profiles);
		assertEquals(1, profiles.size());
		assertEquals("Curtis Mayfield", profiles.get(0).getName());
	}
	
	@Test
	public void testGetProfilesByCategoryAndKeywords() {
		String category = "artist";
		List<Profile> profiles = profileService.getProfilesByCategoryAndKeywords(category, keywords);
		assertNotNull(profiles);
		assertEquals(1, profiles.size());
		assertEquals("Curtis Mayfield", profiles.get(0).getName());
	}
}
