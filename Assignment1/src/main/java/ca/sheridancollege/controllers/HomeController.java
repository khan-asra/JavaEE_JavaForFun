package ca.sheridancollege.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This is a Controller class.The controller annotation tells the framework that
 * this is the class that it must manage
 * 
 * @author asra.k
 *
 */

@Controller
public class HomeController {

	/**
	 * handles Http GET request for /
	 * 
	 * @return index.html
	 */
	@GetMapping("/")
	public String goHome() {
		return "index";
	}

	/**
	 * handles Http GET request for /javaFun
	 * 
	 * @return javaFun.html
	 */
	@GetMapping("/form")
	public String goJavaFun() {
		return "javaFun";

	}

	/**
	 * Values coming from the form.
	 * 
	 * @param yesOrNo        Request parameter for selected radio button value
	 * @param addToMailCheck Request parameter for Check box button value
	 * @param name           Request parameter for name
	 * @param email          Request parameter for email
	 * @param response
	 * @throws IOException
	 */
	@PostMapping("/submitForm")
	public void submitForm(@RequestParam String rbYesOrNo, @RequestParam(required = false) String chkAddToMail,
			@RequestParam String name, @RequestParam String email,

			HttpServletResponse response) throws IOException {

		if (chkAddToMail == null) {
			chkAddToMail = "no";
		}

		String responseString;
		// if add to mail is no and java is fun is yes
		if (chkAddToMail.equalsIgnoreCase("no") & rbYesOrNo.equalsIgnoreCase("yes")) {

			responseString = "<!DOCTYPE html>\n" + "		<html>\n" + "		<head>\n"
					+ "		<meta charset=\"UTF-8\">\n" + "		<title>Assignment 1</title>\n" + "		</head>\n"
					+ "		<body>\n" + "			\n" + "			\n"
					+ "			<h1>Thanks for filling out the form, " + name + " </h1>\n"
					+ "			<h2>Glad you're having fun!</h2>\n"
					+ "			<h3> We won't add your email to our list.</h3>\n" + "			\n" + "		</body>\n"
					+ "		</html>";

		}
		// if add to mail is no and java is fun is no
		else if (chkAddToMail.equalsIgnoreCase("no") & rbYesOrNo.equalsIgnoreCase("no")) {

			responseString = "<!DOCTYPE html>\n" + "		<html>\n" + "		<head>\n"
					+ "		<meta charset=\"UTF-8\">\n" + "		<title>Assignment 1</title>\n" + "		</head>\n"
					+ "		<body>\n" + "			\n" + "			\n"
					+ "			<h1>Thanks for filling out the form, " + name + " </h1>\n"
					+ "			<h2>Hope it gets better!</h2>\n"
					+ "			<h3> We won't add your email to our list.</h3>\n" + "			\n" + "		</body>\n"
					+ "		</html>";

		}
		// if add to mail is yes and java is fun is no
		else if (chkAddToMail.equalsIgnoreCase("yes") & rbYesOrNo.equalsIgnoreCase("no")) {
			responseString = "<!DOCTYPE html>\n" + "		<html>\n" + "		<head>\n"
					+ "		<meta charset=\"UTF-8\">\n" + "		<title>Assignment 1</title>\n" + "		</head>\n"
					+ "		<body>\n" + "			\n" + "			\n"
					+ "			<h1>Thanks for filling out the form, " + name + " </h1>\n"
					+ "			<h2>Hope it gets better!</h2>\n" + "			<h3> We'll add your email: " + email
					+ " to our list.</h3>\n" + "			\n" + "		</body>\n" + "		</html>";
		}
		// if add to mail is yes and java is fun is yes
		else {
			responseString = "<!DOCTYPE html>\n" + "		<html>\n" + "		<head>\n"
					+ "		<meta charset=\"UTF-8\">\n" + "		<title>Assignment 1</title>\n" + "		</head>\n"
					+ "		<body>\n" + "			\n" + "			\n"
					+ "			<h1>Thanks for filling out the form, " + name + " </h1>\n"
					+ "			<h2>Glad you're having fun! </h2>\n" + "			<h3> We'll add your email: " + email
					+ "  to our list. </h3>\n" + "			\n" + "		</body>\n" + "		</html>";
		}
		// Get an instance of the PrintWriter from response.
		PrintWriter out = response.getWriter();

		out.println(responseString);
		System.out.println(chkAddToMail + "  " + rbYesOrNo);

	}

}
