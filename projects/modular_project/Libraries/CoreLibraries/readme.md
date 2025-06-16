## The core libraries
This module contains all the domain concepts like domain entities, the domain logic and the most important rules of 
the entire app. Also is included all the business logic like domain events, 
all the use cases in an abstraction layer. This module define interfaces 
and outer projects implement this abstraction. 

As a rule this module have to be isolated from the other modules.

It follows the ports and adaptors pattern and the DDD<Domain Driven Design> pattern.

### Componets
- Domain Entities
- Repository, services, commands and use cases 
  it is defined as interfaces.
- Some unit test.s