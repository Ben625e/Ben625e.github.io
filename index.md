---
layout: default
title: Benjamin Mills ePortfolio
---
# Welcome to My CS-499 ePortfolio
My name is Benjamin Mills and this is my ePortofolio which highlights my time and efforts at SNHU. This ePortfolio will take you through my personal journey in the Computer Science world from start to finish. You can expect to see 3 artifacts later on that highlight what I have learned and how I have improved throughout my time at SNHU.

## Introduction
I am a Computer Science Major at SNHU but that isn't where I started. Beginning in Highschool I found myself interested in technology, computers and programming were a major part of my life. I used computers for many aspects of my life but my biggest deciding factor on pursuing further education on them was my older brother. He was always participating in competitions that I would get to see but one that stuck out to me was a robotics competition where his team built a robot that could navigate an underwater maze. At the time I decided I would follow in his footsteps by getting the same degree in CS which led to me starting at a community college where I enrolled at AACC. I started in 2020 and finished in late 2022 with a Associate in Science in Computer Science. From there I spent my time completing certifications and continuing my learning as finacial setbacks prevented me from immediately starting on my Bachelors. Ultimately I decided on continuing my education where my oldest brother got his degree from, SNHU, in 2024.

Coming into SNHU, I had the basics of programming from AACC and developed IT concepts from my outside certifications. So when I started I felt confident in my ability to code and thought that I would excell with ease. Not that my confidence was shattered but certainly was put to the test throughout my time at SNHU as new concepts I was unfamiliar with would pop up or what I thought I was good at actually had much room for improvements. I felt myself being challenged in my courses and the topics I knew well at a surface level were discussed at a much deeper depth that often made me question if I would do well in once I leave the program. However, with challenge came a need to prove myself which continues to this day as I continue to improve myself and apply my knowledge in relevant ways.

My previous course work found on my Github help highlight my improvement through this course. I purposefully chose an older project for my artifacts to improve so my improvements are much more clearly shown while also choosing a much more recent project to highlight my current skills. This ePortfolio will showcase my skills aquired through my time at SNHU by drawing attention to 3 specific artifacts but they are only a small portion of my talents as it does not include my outside learnings like my certifications or personal projects. Despite that, this ePortfolio will highlight my strengths in programming and specifically target concepts relating to Software Design and Engineering, Algorithms and Data Structures, and Databases.

One professional value that has been taught to me is collaboration. While the artifacts were done independently, my personal projects and the projects they were built on highlight the importance of collaboration in a team environment. The project used for artifact 3 had the website visuals already designed and created which made my job of implementation much faster and streamlined. Similarly, in my personal projects I break up tasks with my group on people's strength while incorporating their feedback and offering my input on their work. A good example is in one of my project for visual entertainment, I had my colleague create some of the more complex visuals since my strength is in the programming side while they are very creative. Throughout the capstone, I had to explain what was done and what will be done which replicate communicating in a professional setting. From the plan phase to the final reflection, the level of communication I performed is similar to real world communication with stakeholders on project status.

In order to create programs that are efficient and scaleable, I have learned and ingrained skills related to data structures and algorithms. These skills help decide what data structure will best fit any given scenario and understand how to improve parts of the programs resource consumption which may be storage, memory, or speed. Creating efficient and scaleable programs isn't enough to achieve value though, that is why I developed strong software engineering skills and soft skills to recognize needs of the project. These software engineering skills create programs that not only reach the goal, but do so in a way that structured and targetted. Soft skills like empathy and targetted questioning help me understand the problem deeper to create a solution that solves their problem rather than just hitting a set of requirements. Throughout this program, my professional certifications, and my personal life, one fact has remained true which is always the need more security. Secure concepts have been drilled into me in every aspect of my teaching and have led me to creating code that always have security at the forefront of its design.

This portfolio's main focus is based around 3 artifacts that improve upon old projects completed in this course. The projects selected will be listed under the respective artifact and will have links to both the original and enhanced version. The first artifact takes a look at an older project completed earlier on in my course which focuses on security automation. This enhancement will focus on the projects goal and what is missing the original projects design that can be added in addition to what can be improved on. This enhancement highlights my critical thinking and secure coding principles as this project focuses on value and understanding project goals from my addition rather than technical skill. The second enhancement focuses on efficiency and communication by increasing the overall speed of the program through data structure changes and coding adjustments. The second enhancement will highlight my skills in reimplementation of existing code and my ability to effectively convey complex topics in ways anyone can understand. The final enhancement will take place on one of my most recent projects and highlight my current technical skill. This enhancement will encorporate soft skills like critical thinking and technical skills like web development or MongoDB. Before enhancements were made on the projects, I first looked over the already existing projects to highlight its current state and explain the specific enhancement in a short informal presentation known as a code review.

## Code Review

<div class="video-container">
  <iframe width="640" height="390" 
    src="https://www.youtube.com/embed/GnDcM9CBogA" 
    title="Benjamin Mills CS-499 Code Review" frameborder="0" 
    allowfullscreen>
  </iframe>
</div>

<style>
.video-container {
  position: relative;
  padding-bottom: 56.25%;
  height: 0;
  overflow: hidden;
  max-width: 100%;
}

.video-container iframe {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
</style>

Above you'll find a link to my code review that was recorded before the enhancements were done to the projects. If the above video does not work you can also find my video [Here](https://www.youtube.com/watch?v=GnDcM9CBogA). A code review is a review of the code which involves checking the code that it meets certain functional requirements, is error free, built to standard, properly documented, and meets style guidelines. It analyzes the code for both problems and areas of improvements, offering a chance for self reflection and is a great tool for collaboration. This was an individual code review which had me analyzing the existing projects and checking them against the guidelines set in the checklist. It also had me explaining the proposed enhancements deeper, explaining where and how it fits into the existing project.

To summarize the existing code review, it starts by taking a look at the CS-320 Project which is used in the first and second artifact. The project is written in Java and inspected in the Eclipse IDE. The project was originally planned to be a part of a mobile application, with security and speed being a top concern. The project consists of 3 many parts which are the Appointment, Contact, and Task portions. Each portion has 4 classes, 1 is a base object to house data, 1 is a controller class which stores an arraylist of the base objects, and 2 test classes for the base object and the controller. Each base class, like the Appointment class, stores a unique ID and relevant data tied to that class. The controller class, like AppointmentService class, handles operations like adding a new Appointment or modifying existing objects. The test classes test for the specific requirements from the original project and each created function using JUnit. From the provided checklist, the project passes the structure portion for the most part although a library function could have been used if the project was to remain in the arraylist structure. The project could have improvements on the documentation, with unnecessary documentation and slightly inconsistant commenting strucutre throughout. The project passes the arithmetic portion although it doesn't apply to the existing code. The project generally passes the loops portion of the checklist although there may be a better way to structure base cases. Finally, the project passes the all the defense criteria in the checklist that applies to this specific project.

The first enhancement was made with the topic of Software Design and Engineering in mind. The code review explains that the planned enhancement will expand on the missing CRUD operations from the project, which is the Read operation. The ability to get stored data is crucial for this mobile application but was a missing part of the original project which was not recognized. The read operation will be incorporated into all 3 portions of the project, inside of the controller classes. This enhancement highlights on the design aspect, as it recognizes crucial overlooked functionality which would make a good portion of the mobile application completely unusable.

The second enhancement was made with the topic of Algorithms and Data Structures in mind. This will also be made in the CS-320 project. This enhancement will change the arraylist structure in the controller classes, into a binary search tree, or BST, structure instead. The code review explains that this will apply to all 3 portions of the project but will still be returning an arraylist from the created read functionality in enhancement 1. The reasoning behind this decision is that the other portion of the mobile application that will be making use of the read function will likely be expecting an arraylist and this will allow those functions to still work properly. The code review defends the choice of a BST by explaining its speed benefits, maintainability, and ease of integration of existing code.

The code review then looks at the other project being worked on from CS-465. It is a fullstack project that shows a travel booking website. The website contains 2 key parts, which are the customer facing part and the Single-page application (SPA) administrator part. The SPA allows for adding and editing trips once logged in and will be refleced in both the SPA and the main customer page of the website. The code looks more in depth at the specific parts of the code that will be worked on in the enhancement. These parts are the app_api controllers and router. This project is one of the more recent projects I completed which is reflected in the documentation and techniques used. This is shown by the code passing everything on the checklist, with a small note on leftover testing stubs left in but purposefully left in for website maintenance.

The code review then explains the enhancement that will be done on the project with the topic of Databases in mind. The website is missing the ability to delete trips or admin users without directly removing them from the MongoDB database. The enhancement plans on adding deletion capabilities to the website for both trips and users. This enhancement is defending by explaining how trips may no longer be avalible so without being able to delete them may confused customers. Similarly, the code review explains the security vulnerabilities leaving admin accounts open without the ability to delete them when the employee is no longer a part of the company or their account is compromised.

The conclusion of the code review quickly goes back over the projects and the enhancements that will be done. It mentions where the enhancements can be found, in this ePortfolio.

## Artifact One - Software Design and Engineering
The Original Project can be found -> [Here](https://github.com/Ben625e/CS-320)

The Enhanced Project can be found -> [Here](https://github.com/Ben625e/Ben625e.github.io/tree/main/BenjaminMillsCS320ProjectOneEnhancement1)

The following images provide quick recap of what was shown in the code review:<br><br>

![Project View](/docs/assets/images/CS320ProjectView.png)

This shows the original projects files, note that each of the 3 portions of the project (AppointmentService, ContactService, and TaskService) each have 2 functional class files and 2 testing class files.<br><br><br>

![Object View](/docs/assets/images/CS320ObjectView.png)

This shows one of the base classes, the Appointment class. Note on line 12 the unique ID, this is shared between all the base classes. You can also see that certain restrictions are placed on each stored data like on line 15, where it says that descriptions should not be empty and should be less than 51 characters.<br><br><br>

![Service View](/docs/assets/images/CS320ServiceView.png)

This shows one of the controller classes, the AppointmentService class. Note that the original implementation used an ArrayList structure, also known as a vector in other languages.<br><br><br>

![Test View](/docs/assets/images/CS320TestView.png)

This shows one of the testing classes, the AppointmentServiceTest class. The testing classes make use of JUnit for executing the test scripts.<br>

The artifact expands on a security project done in my CS program by adding read functionality to the locally stored data and adding JUnit test functions to accompany the newly created functions. The artifact uses an insertion method for gathering and sorting the data into an ArrayList for Java or more commonly known as a vector. The JUnit test is a positive test that inserts data and checks that the data is properly sorted when the read function is called.<br><br>

![Read View](/docs/assets/images/CS320ReadEnhance1.png)
![Test View](/docs/assets/images/CS320ReadTestEnhance1.png)

The above images show the implementation of the read function and accompanying test function in the Appointment portion of the project. This was also implemented for the Contact and Task portions of the project.<br>

The artifact was chosen as it expands on security knowledge which I felt the need to get more practice is. In my personal projects, I often create projects that expand on my creative and design skills. I often make programs with the purpose of entertainment which require strong design principles paired with practical development skills that can accomplish what I am envisioning. Which is why when choosing artifact projects, I wanted to choose something that I could apply what I have practice in while also highlighting skills I don’t often showcase in my work. The artifact shows my ability to efficiently and effectively create software that solves a design flaw with the program, in this case, the lack of being able to retrieve the stored data. It also shows growth as this class was a much earlier class in my program, allowing me to apply my new concepts to old projects to show greater improvement I have made over my course in the program. This enhancement highlights my security knowledge, one of the leading reasons why I chose this project specifically as I got to further implement and improve my knowledge on security concepts. This enhancement created a more complete program with a filled design flaw, cleaner code, and a stronger security system.

When working on this project, I got to look at my old standards and directly compare them with my new standards. One thing I found interesting that I did back then was I over labeled the code, adding comments to code comparisons that are very obvious. Back then, I remembered my mindset being the more comments the better since it makes it easier to find out what everything does as everything is explained. It may be that I just am more experienced with coding now, but I now find all those comments distracting, I updated the comment structure to give more generalized descriptions and only labeled the not immediately understood parts of the code which look much cleaner now. I don’t think that either method is wrong, however it was interesting to see how I have grown in small parts of my coding standard with the comment structure just being a single example of that. Below you will see the previous object image versus the restructured version after the enhancement was completed. 

![Object View](/docs/assets/images/CS320ObjectView.png)
![Comment View](/docs/assets/images/CS320CommentEnhance1.png)

One roadblock I had when creating the code that I didn’t recognize in the proposal was the language this project was written in. Python is my main language, but the project was written in Java. Although the logic was correct in the proposal, I failed to recognize that Java does not automatically know how to compare with comparator signs like < certain data types such as strings. That caused a small hiccup since I needed to compare the data types for the function, however I quickly read through the documentation and found comparison methods. After reading how the comparison methods worked, I was able to adjust my logic and get the same result. Another little snag I hit was when trying to come up with a negative test for the function. I wanted to create a positive and negative test, that would cause the catch to execute however I tried several negative tests, and they all failed because they would get stopped earlier on. As an example, I was thinking of putting in a null value but the way the Appointment class is set up, a null value is immediately recognized, and an exception is thrown. Due to many negative tests getting caught, there wasn’t any need for a negative test in this case, so I decided that a positive test was sufficient. The biggest takeaway from this enhancement is how much I have grown from when I took this course, my speed at creating and overcoming roadblocks is much faster than back then. I remember needing to always look up different documentation to read while this time I felt I had it all memorized and it came naturally when scripting.

## Artifact Two - Algorithms and Data Structures
The Original Project can be found -> [Here](https://github.com/Ben625e/CS-320)

The Enhanced Project can be found -> [Here](https://github.com/Ben625e/Ben625e.github.io/tree/main/BenjaminMillsCS320ProjectOne)

This artifact improves the efficiency of the controllers by moving from an ArrayList structure to a BST structure. The entire code had to be reformatted to incorporate the new structure, and the security automation JUnit scripts had to reworked with some new tests being added. This work was done on all 3 portions of the project which include the Appointment, Contact, and Task portions of the project and ultimately created 6 new scripts for the project.<br><br>

![Node View](/docs/assets/images/CS320NodeEnhance2.png)
![BST View](/docs/assets/images/CS320BSTEnhance2.png)
![Test 2 View](/docs/assets/images/CS320TestBSTEnhance2.png)
![Read 2 View](/docs/assets/images/CS320ReadEnhance2.png)

The above images show the implmentation of the BST. The node structure is a newly created classes that is used for the BST implementation. The BST achieves all the previous controller classes functionality. Similarly, the test class achieves all the previous test functions and includes newly added ones to better test the BST.<br><br><br>

This artifact was chosen as it improved further on the project from enhancement one, allowing for the project be brought even more up to my current coding standards. While my first improvement did improve on the project in designed focus ways, the project being older still had algorithmic flaws that could be improved even further would require more time which is why it ultimately spanned two enhancements. It better showcases my improvement during my time in the program as I get to show unique advanced skills, I have by applying them to two separate enhancements. This enhancement shows my ability to recognize how to improve speed efficiency through algorithmic calculations, repurpose code to an entirely new data structure, and how to effectively present those improvements. The artifact can now handle much larger amounts of data much more efficiently and will be more scalable in the future. While not a part of my original proposal, I added three speed testing scripts to the original AppointmentService test script and the new AppointmentBSTService test script to highlight the speed increase. The results are very telling, with the old system taking around 30 seconds to get through the speed tests while the new system takes less than a quarter of a second. The created test scripts and results can be seen below.

![BST Speed View](/docs/assets/images/CS320BSTSpeedEnhance2.png)
![Speed View](/docs/assets/images/CS320SpeedEnhance2.png)
![BST Speed Result View](/docs/assets/images/CS320BSTSpeedResultEnhance2.png)
![Speed Result View](/docs/assets/images/CS320SpeedResultEnhance2.png)

Working on this enhancement further demonstrated how understanding a data structure is only half the battle when implementing them. In my original plan, I had planned for the Node and BST structure to be under one script, however Java easily accommodate that, so I had to split them up over two scripts. This wasn’t a big roadblock but just one of the many instances where Java caused hiccups in my implementation. Another example that tripped me up was how Java treated the variables where it was storing by reference by default, meaning I didn’t need to explicitly define it as a reference variable but also caused further divergence from how I originally planned to implement the BST. Smaller differences that required me looking into libraries and coding documentation occurred in the implementation, such as comparing Strings could not be done with symbols like > or < but required functions like compareTo() to achieve. I will say after this enhancement and writing over 1000+ lines of code to implement it, I am much more familiar with Java and its respective libraries. One thing I also noticed while reworking the JUnit tests was the need for variables that were considered good, with working data. I ended up putting these at the top before tests occurred so if parameters change in the future, instead of having to change the variable in each individual test, you will just have to change the variable at the top, and it will be changed across the whole testing script. Small maintenance improvements like that occurred while working on this enhancement and highlight how I can now recognize coding problems before they occur.

## Artifact Three - Databases
The Original Project can be found -> [Here](https://github.com/Ben625e/CS465-fullstack) (Note: You will have to go to the module8 branch which can also be found [Here](https://github.com/Ben625e/CS465-fullstack/tree/module8))

The Enhanced Project can be found -> [Here](https://github.com/Ben625e/Ben625e.github.io/tree/Enhancement)

The artifact was created delete functionality for the travel booking website created using Angular, MongoDB, and Express. The created functions had to be routed to the database and successfully make changes, which should be shown on the website, and the results should send back the deleted data.<br><br>

![New User View](/docs/assets/images/CS465NewUserEnhance3.png)<br>
This image shows the created account I made on the SPA portion of the websites in the database.<br><br><br>
![New Trip View](/docs/assets/images/CS465NewTripEnhance3.png)<br>
This image shows a newly created trip on the bottom right named “Test’s Trip”.<br><br><br>
![New Trip Data View](/docs/assets/images/CS465NewTripDataEnhance3.png)<br>
This shows the test trip’s information in the database.<br><br><br>
![New Trip Delete View](/docs/assets/images/CS465DeleteTripEnhance3.png)<br>
This screenshot shows a successful delete request, using the unique trip code in the parameters.<br><br><br>
![New Trip Gone View](/docs/assets/images/CS465TripGoneEnhance3.png)<br>
Here it shows the trip gone from both the database and on the website.<br><br><br>
![New User Delete View](/docs/assets/images/CS465DeleteUserEnhance3.png)<br>
This shows a successful delete user function, which requires data to be sent along with the request shown in the email under “Body”.<br><br><br>
![New User Gone View](/docs/assets/images/CS465UserGoneEnhance3.png)<br>
This is the database showing only a single admin user after the delete function was performed.<br>

This project was the most recent project I completed in my program. It was a class taken at the end of my program and was taken right before the capstone in my case. I wanted to have an old project to showcase how I can improve from older and lower quality designed, but also a newer project to highlight my growth through the program. I think that this project accomplishes that greatly as it shows my improvements in coding style, what I am capable of, and overall critical thinking in terms of the project. The artifact itself highlights my skills in web development and working with databases as this artifact makes heavy use of both. The artifact improves the functionality of the website by completing CRUD capabilities. The website was missing the ability to delete from the database which is now possible from this artifacts inclusion.

Creating this was a stressful plan process, I found myself worrying about this one as it was my most recent project but also my least familiar. Web development done in this project was my first- and only-time making use of some of the tools like Postman, RestfulAPI or even Express. Due to that, I came into this enhancement heavily planning of time and thinking on how the implementation should look as well as heavily testing every aspect. Shockingly, this was the enhancement I had the least hiccups on, with no problems from implementation to testing. I think this showcases that it is easy to underestimate what you know in terms of coding and miss out on small things on what you’re familiar with. The 2nd artifact was what I was most familiar with, but I had to look through the most documentation while with this enhancement I was able to find all the relevant libraries without much outside research. The biggest challenge with this project was planning as I wanted to ensure that I didn’t break the website in way I wouldn’t understand but once I started, I found it to be quite a smooth process. My anxiety towards starting this enhancement ended up being overblown and I am now much more confident in my skills in web development from this.

## Conclusion
