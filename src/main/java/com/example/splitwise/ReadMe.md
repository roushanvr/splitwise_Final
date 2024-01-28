steps for making backend Restful(Handle HTTP request)
1) Add maven dependencies of springboot web starter
  1.1) search and add to pom
2) Decorate your controller with @RestController
3) HTTP method supported by methods of controller
4) Change parameter type of methods in controller to receive data sent
   with HTTP (@RequestBody, @RequestParam)