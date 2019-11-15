/**
 * 
 */
package com.hmhco.sgminterest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hmhco.sgminterest.domain.Profile;
import com.hmhco.sgminterest.domain.User;
import com.hmhco.sgminterest.persistence.UserDAO;
import com.hmhco.sgminterest.persistence.UserRepository;
import com.hmhco.sgminterest.service.ProfileService;

/**
 * @author damodaranv
 *
 */
@RestController
@RequestMapping(value = "/")
public class UserController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

	private final UserDAO userDAO;
	
	@Autowired
	private ProfileService profileService;

	public UserController(UserRepository userRepository, UserDAO userDAO) {
		this.userRepository = userRepository;
		this.userDAO = userDAO;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public List<Profile> addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return profileService.getProfiles(user);
		
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
//		return userRepository.findOne(new Query(Criteria.where("userId").is(userId)), User.class);
		return userRepository.findById(userId);
	}


	@RequestMapping(value = "/responses/{userId}", method = RequestMethod.GET)
	public Object getAllUserResponses(@PathVariable String userId) {
//		User user = userRepository.findOne(new Query(Criteria.where("userId").is(userId)), User.class);
		Optional<User> user = userRepository.findById(userId);
		if (user != null) {
			return userDAO.getAllUserResponses(userId);
		} else {
			return "User not found.";
		}
	}
	
	@RequestMapping(value = "/populate/profile-data", method = RequestMethod.GET)
	public Object populateProfileData() {
		
		
		List<Profile> profileList = createProfilePoulate();
		
		for(Profile profile : profileList) {
			profileService.saveProfile(profile);	
		}
		
		return "User inserted ";
		
	}
	
	private List<Profile> createProfilePoulate() {
		// TODO Auto-generated method stub

		List<Profile> profileList = new ArrayList<Profile>();
		
		Profile profile1 = new Profile(5, "Pablo Ruiz Picass", "artist", "Pablo Ruiz Picass was a Spanish painter, sculptor, printmaker, ceramicist, stage designer, poet and playwright who spent most of his adult life in France. Regarded as one of the most influential artists of the 20th century, he is known for co-founding the Cubist movement, the invention of constructed sculpture,[6][7] the co-invention of collage, and for the wide variety of styles that he helped develop and explore. Among his most famous works are the proto-Cubist Les Demoiselles d\\'Avignon (1907), and Guernica (1937), a dramatic portrayal of the bombing of Guernica by the German and Italian airforces during the Spanish Civil War.", "painter");

		Profile profile2 = new Profile(6, "Peter Paul Rubens", "artist", "Peter Paul Rubens was a Flemish artist. He is considered the most influential artist of Flemish Baroque tradition. Rubens\\'s highly charged compositions reference erudite aspects of classical and Christian history. His unique and immensely popular Baroque style emphasized movement, color, and sensuality, which followed the immediate, dramatic artistic style promoted in the Counter-Reformation. Rubens specialized in making altarpieces, portraits, landscapes, and history painters of mythological and allegorical subjects.", "painter");
				
		Profile profile3 = new Profile(7, "Henri Matisse", "artist", "Henri Matisse was a French artist, known for both his use of colour and his fluid and original draughtsmanship. He was a draughtsman, printmaker, and sculptor, but is known primarily as a painter.[1] Matisse is commonly regarded, along with Pablo Picasso, as one of the artists who best helped to define the revolutionary developments in the visual arts throughout the opening decades of the twentieth century, responsible for significant developments in painter and sculpture.", "painter");

		Profile profile4 = new Profile(8, "Caravaggio", "artist", "Caravaggio was an Italian painter active in Rome, Naples, Malta, and Sicily from the early 1590s to 1610. His painters combine a realistic observation of the human state, both physical and emotional, with a dramatic use of lighting, which had a formative influence on Baroque painter. Caravaggio\\'s innovations inspired Baroque painter, but the Baroque incorporated the drama of his chiaroscuro without the psychological realism. The style evolved and fashions changed, and Caravaggio fell out of favor. In the 20th century interest in his work revived, and his importance to the development of Western art was reevaluated. The 20th-century art historian André Berne-Joffroy stated, What begins in the work of Caravaggio is, quite simply, modern painter.", "painter");

		Profile profile5 = new Profile(9, "Jackson Pollock", "artist", "Jackson Pollock was an American painter and a major figure in the abstract expressionist movement. He was widely noticed for his technique of pouring or splashing liquid household paint onto a horizontal surface (‘drip technique’), enabling him to view and paint his canvases from all angles. It was also called ‘action painter’, since he used the force of his whole body to paint, often in a frenetic dancing style. This extreme form of abstraction divided the critics: some praised the immediacy and fluency of the creation, while others derided the random effects. In 2016, Pollock\\'s painter titled Number 17A was reported to have fetched US $200 million in a private purchase.A reclusive and volatile personality, Pollock struggled with alcoholism for most of his life. In 1945, he married the artist Lee Krasner, who became an important influence on his career and on his legacy. Pollock died at the age of 44 in an alcohol-related single-car accident when he was driving. In December 1956, four months after his death, Pollock was given a memorial retrospective exhibition at the Museum of Modern Art (MoMA) in New York City. A larger, more comprehensive exhibition of his work was held there in 1967. In 1998 and 1999, his work was honored with large-scale retrospective exhibitions at MoMA and at The Tate in London.", "painter");

		Profile profile6 = new Profile(10, "Edward Hopper", "artist", "Edward Hopper was an American realist painter and printmaker. While he is best known for his oil painters, he was equally proficient as a watercolorist and printmaker in etching. Both in his urban and rural scenes, his spare and finely calculated renderings reflected his personal vision of modern American life.At an impasse over his oil painters, in 1915 Hopper turned to etching. By 1923 he had produced most of his approximately 70 works in this medium, many of urban scenes of both Paris and New York.[34][35] He also produced some posters for the war effort, as well as continuing with occasional commercial projects.[36] When he could, Hopper did some outdoor watercolors on visits to New England, especially at the art colonies at Ogunquit, and Monhegan Island.", "painter");

		Profile profile7 = new Profile(11, "Janet Fish", "artist", "Janet Fish is a contemporary American realist artist. She paints still life painters, some of light bouncing off reflective surfaces, such as plastic wrap containing solid objects and empty or partially filled glassware. Fish is known for her large, bold Realist still lifes, especially the way she paints everyday items such as clear glassware partially filled with water, concentrating on the shapes of the objects and the play of light off of their surfaces. She is interested in painter light and a concept she has on occasion called packaging. For instance, if she paints a jar of pickles, the jar becomes packaging, and this can translate into a searching for the light that describes the jar, and a subsequent translation into color. She created still life painters of grocery store products packaged in cellophane. She said that the plastic wrap catches the light and creates fascinating reflections.", "painter");

		Profile profile8 = new Profile(12, "Paul Klee", "artist", "Paul Klee was a Swiss-born artist. His highly individual style was influenced by movements in art that included Expressionism, Cubism, and Surrealism. Klee was a natural draftsman who experimented with and eventually deeply explored color theory, writing about it extensively; his lectures Writings on Form and Design Theory (Schriften zur Form und Gestaltungslehre), published in English as the Paul Klee Notebooks, are held to be as important for modern art as Leonardo da Vinci\\'s A Treatise on painter for the Renaissance. He and his colleague, Russian painter Wassily Kandinsky, both taught at the Bauhaus school of art, design and architecture. His works reflect his dry humor and his sometimes childlike perspective, his personal moods and beliefs, and his musicality.", "painter");

		Profile profile9 = new Profile(13, "Edouard Manet", "artist", "Edouard Manet was a French modernist painter. He was one of the first 19th-century artists to paint modern life, and a pivotal figure in the transition from Realism to Impressionism. His early masterworks, The Luncheon on the Grass (Le déjeuner sur l\\'herbe) and Olympia, both 1863, caused great controversy and served as rallying points for the young painters who would create Impressionism. Today, these are considered watershed painters that mark the start of modern art. The last 20 years of Manet\\'s life saw him form bonds with other great artists of the time, and develop his own style that would be heralded as innovative and serve as a major influence for future painters.", "painter");

		Profile profile10 = new Profile(14, "Gustav Klimt", "artist", "Gustav Klimt was an Austrian symbolist painter and one of the most prominent members of the Vienna Secession movement. Klimt is noted for his painters, murals, sketches, and other objets d\'art. Klimt\'s primary subject was the female body,[1] and his works are marked by a frank eroticism.[2] In addition to his figurative works, which include allegories and portraits, he painted landscapes. Among the artists of the Vienna Secession, Klimt was the most influenced by Japanese art and its methods. Early in his artistic career, he was a successful painter of architectural decorations in a conventional manner. As he developed a more personal style, his work was the subject of controversy that culminated when the painters he completed around 1900 for the ceiling of the Great Hall of the University of Vienna were criticized as pornographic. He subsequently accepted no more public commissions, but achieved a new success with the painters of his golden phase, many of which include gold leaf. Klimt\'s work was an important influence on his younger contemporary Egon Schiele.", "painter");

		profileList.add(profile1);
		profileList.add(profile2);
		profileList.add(profile3);
		profileList.add(profile4);
		profileList.add(profile5);
		profileList.add(profile6);
		profileList.add(profile7);
		profileList.add(profile8);
		profileList.add(profile9);
		profileList.add(profile10);
		
		return profileList;
	}

}