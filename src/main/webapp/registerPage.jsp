<%@include file="header.jsp" %>


      <!-- talk -->
      <div id="talk" class="talk">
         <div class="container">
            <div class="row ">
               <div class="col-md-6 ">
                  <div class="wines">
                     <h3>Hello our new potential customer</h3>
                     <p>Description</p>
                    
                  </div>
               </div>
               <div class="col-md-6 ">
                  <form class="main_form " action="/online-shop/register">
                     <div class="row">
                        <div class="col-md-12 ">
                           <input class="form_contril" placeholder="Login " type="text" name="login">
                        </div>
                        <div class="col-md-12">
                           <input class="form_contril" placeholder="Password" type="password" name="password">
                        </div>
                        <div class="col-md-12">
                           <input class="form_contril" placeholder="Email" type="text" name="email">
                        </div>
                        <div class="col-md-12">
                           <input class="form_contril" placeholder="First name" type="text" name="fname">
                        </div>
                        <div class="col-md-12">
                           <input class="form_contril" placeholder="Last name" type="text" name="lname">
                        </div>
                        <div class="col-sm-12">
                           <input class="send_btn" type="submit" value="Register">
                        </div>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </div>
      <!-- end talk -->
<%@include file="footer.jsp" %>