# Swagger example

Raw swagger2 docs  
http://localhost:8080/swagger-ui/index.html

To add swagger to spring 2.6.6, add the following dependencies in maven with version 3.0

    springfox-swagger2
    springfox-swagger-ui
    springfox-boot-starter

In SwaggerConfig, a Docket is created. In the docket you specify,  configure what to be shown in documention, which apis, etc.
In ApiDetails you can configure the text shown in the documentation page.

To add more info to an API (instead of swagger to pring the method's name only), add the method below to each api in your controllers

    @ApiOperation

    Example:
    @GetMapping("/{id}")
    @ApiOperation(
            value = "Find specific contact by id",
            notes = "Provide an id of a person to look up specific contact from the address book",
            response = Contact.class)
    public Contact getContact(@PathVariable String id)

To add description to a param, use the **@ApiParam** annotation. See example in 

        public Contact getContact(@ApiParam() @PathParam id)

! To add description to a Model/Bean, use the **@ApiModel** and **@ApiModelProperty**. 
As an example see the **Contact** class