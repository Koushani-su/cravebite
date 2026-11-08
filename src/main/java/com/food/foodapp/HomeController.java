package com.food.foodapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
                <html>
                <head>
                <title>CraveBite - Food App</title>
                <style>
                    body { font-family: Arial; margin: 0; padding: 0; text-align: center; background: #FFF8E1; }
                    .page { display: none; min-height: 100vh; padding: 20px; box-sizing: border-box; }
                    .loginPage { background: linear-gradient(180deg, #FF6D00, #FFA726, #FFEB3B); padding-top: 80px; }
                    .bigLogo { font-size: 60px; color: white; margin: 0; }
                    .bigLogo span { color: #D32F2F; }
                    .tagline { font-size: 20px; font-weight: bold; color: #5D4037; }
                    .loginCard { background: white; padding: 25px; border-radius: 25px; width: 100%; max-width: 380px; margin: 20px auto; box-shadow: 0 10px 30px rgba(0,0,0,0.2); }
                    h1 { color: #D32F2F; font-size: 32px; }
                    .topBar { max-width: 520px; margin: 0 auto 10px auto; display: flex; justify-content: space-between; align-items: center; background: white; padding: 12px 15px; border-radius: 20px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }
                    .box { background: white; border-radius: 15px; padding: 15px; margin: 15px auto; max-width: 520px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); text-align: left; }
                    .box h2 { color: #FF6D00; margin-top: 0; }
                    .item { display: flex; justify-content: space-between; align-items: center; padding: 10px 0; border-bottom: 1px dashed #ddd; font-size: 17px; gap: 10px; }
                    .left { display: flex; align-items: center; gap: 10px; flex: 1; }
                    .left img { width: 60px; height: 60px; border-radius: 12px; object-fit: cover; }
                    .price { color: #2E7D32; font-weight: bold; display: block; }
                    .tag { background: #FFC107; padding: 2px 8px; border-radius: 10px; font-size: 12px; }
                    .btn { background: #D32F2F; color: white; border: none; padding: 8px 14px; border-radius: 20px; font-weight: bold; cursor: pointer; }
                    .addBtn { background: #2E7D32; color: white; border: none; padding: 8px 12px; border-radius: 12px; font-weight: bold; cursor: pointer; }
                    .bigChoice { background: white; border-radius: 20px; padding: 25px 15px; margin: 12px auto; max-width: 520px; cursor: pointer; box-shadow: 0 4px 12px rgba(0,0,0,0.1); }
                    #searchBox, #searchBox2 { width: 100%; max-width: 520px; padding: 13px; border-radius: 20px; border: none; font-size: 16px; margin: 10px 0; box-shadow: 0 4px 10px rgba(0,0,0,0.1); box-sizing: border-box; }
                    .inputBox { width: 100%; padding: 12px; margin: 6px 0; border-radius: 12px; border: 1px solid #ddd; font-size: 15px; box-sizing: border-box; }
                    .greenBtn { background: #2E7D32; color: white; border: none; padding: 13px; width: 100%; border-radius: 15px; font-size: 17px; font-weight: bold; cursor: pointer; margin-top: 10px; }
                    .backBtn { background: white; border: none; padding: 8px 14px; border-radius: 20px; cursor: pointer; font-weight: bold; }
                    .cartRow { display: flex; justify-content: space-between; padding: 10px 0; border-bottom: 1px dashed #ddd; }
                    .payBox { background: #FFF3E0; padding: 12px; border-radius: 12px; margin: 10px 0; text-align: left; }
                    .trackStep { padding: 10px; border-left: 4px solid #ddd; margin: 8px 0 8px 10px; font-size: 17px; text-align: left; }
                    .trackActive { border-color: #2E7D32; font-weight: bold; color: #2E7D32; }
                    .historyBox { background: #E8F5E9; padding: 10px; border-radius: 12px; margin: 8px 0; font-size: 14px; text-align: left; }
                    .stars { font-size: 30px; cursor: pointer; }
                    .rateSmall { font-size: 13px; color: #FF9800; cursor: pointer; display: block; margin-top: 2px; }
                    .floatCart { position: fixed; bottom: 20px; right: 20px; background: #D32F2F; color: white; padding: 14px 20px; border-radius: 50px; font-weight: bold; box-shadow: 0 6px 20px rgba(0,0,0,0.3); cursor: pointer; z-index: 50; border: none; font-size: 16px; }
                </style>
                </head>
                <body>

                <!-- PAGE 1 : LOGIN -->
                <div id="page1" class="page loginPage" style="display:block;">
                    <h1 class="bigLogo">🍔 Crave<span>Bite</span></h1>
                    <p class="tagline">Hungry? Your feast is just one click away!</p>
                    <div class="loginCard">
                        <h2 style="margin-top:0;">👋 Welcome Back!</h2>
                        <p style="color:#777;">Login to start your craving journey</p>
                        <input class="inputBox" id="loginName" placeholder="Your Name - e.g. Neha">
                        <input class="inputBox" id="loginPhone" placeholder="Phone Number - 9876543210">
                        <button type="button" class="greenBtn" onclick="doLogin()">Login / Continue →</button>
                        <button type="button" class="greenBtn" style="background:#FF6D00;" onclick="skipLogin()">Skip Login → Continue as Guest</button>
                        <p style="font-size:13px; color:#999;">By continuing, you agree to taste amazing food 😋</p>
                    </div>
                    <p style="font-weight:bold; color:#5D4037;">⭐ 4.9 Rated | 30 Min Delivery | All Under Rs 500</p>
                </div>

                <!-- PAGE 2 : HOME -->
                <div id="page2" class="page">
                    <div class="topBar"><span id="welcomeText" style="font-weight:bold;">👋 Hi!</span><button class="btn" onclick="logout()">Logout</button></div>
                    <h1>🍔 CraveBite</h1>
                    <p style="font-weight:bold; color:#5D4037;">What are you craving today?</p>
                    <input id="searchBox" onkeyup="doSearch()" placeholder="🔍 What do you want to eat? Try Biryani, Momos...">
                    <p>Choose your craving:</p>
                    <div class="bigChoice" onclick="openFood('veg')" style="border:3px solid #2E7D32;">
                        <div style="font-size:28px; font-weight:bold; color:#2E7D32;">🟢 VEG</div>
                        <div style="color:#666;">Pure Veg - Pani Puri, Momos, Biryani & More →</div>
                    </div>
                    <div class="bigChoice" onclick="openFood('nonveg')" style="border:3px solid #D32F2F;">
                        <div style="font-size:28px; font-weight:bold; color:#D32F2F;">🔴 NON-VEG</div>
                        <div style="color:#666;">Chicken / Egg - Biryani, Momos, Roll & More →</div>
                    </div>
                    <div class="box"><h2>📜 My Orders</h2><div id="historyList"><p>No orders yet. Order something delicious!</p></div></div>
                    <button class="btn" onclick="goPage(4)">🛒 View Cart</button>
                </div>

                <!-- PAGE 3 : FOOD LIST -->
                <div id="page3" class="page">
                    <div class="topBar"><button class="backBtn" onclick="goPage(2)">← Back</button><b id="foodTitle">Food List</b><button class="btn" onclick="goPage(4)">Cart (<span id="cartCount2">0</span>)</button></div>
                    <h1 id="foodHeading">🟢 Veg Menu</h1>
                    <input id="searchBox2" onkeyup="doSearch2()" placeholder="🔍 Search in this menu...">
                    <div id="vegList">
                        <div class="box"><h2>🌶️ Spicy & Chatpata</h2>
                            <div class="item"><div class="left"><img src="https://www.gamintraveler.com/wp-content/uploads/2024/08/Pani-Puri.jpg"><span>Aloo Pani Puri (6 pc) <span class="tag">Spicy</span><span class="rateSmall" onclick="openRate('Veg Pani Puri')">⭐ 4.8 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹60</span><button class="addBtn" onclick="addToCart('Veg Pani Puri', 60)">Add +</button></span></div>
                            <div class="item"><div class="left"><img src="https://c.ndtvimg.com/2024-06/eebcuqqg_bhel-puri_625x300_27_June_24.jpg?im=FaceCrop"><span>Veg Bhel Puri<span class="rateSmall" onclick="openRate('Veg Bhel Puri')">⭐ 4.6 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹70</span><button class="addBtn" onclick="addToCart('Veg Bhel Puri', 70)">Add +</button></span></div>
                            <div class="item"><div class="left"><img src="https://www.carolinescooking.com/wp-content/uploads/2023/02/aloo-chaat-photo.jpg"><span>Aloo Chaat<span class="rateSmall" onclick="openRate('Aloo Chaat')">⭐ 4.7 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹80</span><button class="addBtn" onclick="addToCart('Aloo Chaat', 80)">Add +</button></span></div>
                        </div>
                        <div class="box"><h2>🍔 Street Food</h2>
                            <div class="item"><div class="left"><img src="https://images.slurrp.com/prod/articles/fw1pvi74h9.webp?impolicy=slurrp-20210601&width=1200&height=900&q=75"><span>Vada Pav<span class="rateSmall" onclick="openRate('Vada Pav')">⭐ 4.9 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹50</span><button class="addBtn" onclick="addToCart('Vada Pav', 50)">Add +</button></span></div>
                            <div class="item"><div class="left"><img src="https://www.kuchpakrahahai.in/wp-content/uploads/2026/02/veg-momos-recipe.jpg"><span>Veg Momos (8 pc)<span class="rateSmall" onclick="openRate('Veg Momos')">⭐ 4.7 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹100</span><button class="addBtn" onclick="addToCart('Veg Momos', 100)">Add +</button></span></div>
                        </div>
                        <div class="box"><h2>🍕 Main Course</h2>
                            <div class="item"><div class="left"><img src="https://masaladiaries.com/wp-content/uploads/2025/08/indian-chicken-biryani-restaurant-style-683x1024.jpg"><span>Veg Dum Biryani<span class="rateSmall" onclick="openRate('Veg Biryani')">⭐ 4.9 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹180</span><button class="addBtn" onclick="addToCart('Veg Biryani', 180)">Add +</button></span></div>
                            <div class="item"><div class="left"><img src="https://cdn.loveandlemons.com/wp-content/uploads/opengraph/2023/02/vegetarian-pizza-recipe.jpg"><span>Veg Pizza<span class="rateSmall" onclick="openRate('Veg Pizza')">⭐ 4.7 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹250</span><button class="addBtn" onclick="addToCart('Veg Pizza', 250)">Add +</button></span></div>
                        </div>
                        <div class="box"><h2>🍰 Sweets & Drinks</h2>
                            <div class="item"><div class="left"><img src="https://www.vegrecipesofindia.com/wp-content/uploads/2022/10/gulab-jamun.jpg"><span>Gulab Jamun (4 pc)<span class="rateSmall" onclick="openRate('Gulab Jamun')">⭐ 4.9 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹80</span><button class="addBtn" onclick="addToCart('Gulab Jamun', 80)">Add +</button></span></div>
                            <div class="item"><div class="left"><img src="https://www.sharmispassions.com/wp-content/uploads/2023/08/sweet-lassi1.jpg"><span>Sweet Lassi<span class="rateSmall" onclick="openRate('Sweet Lassi')">⭐ 4.7 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹70</span><button class="addBtn" onclick="addToCart('Sweet Lassi', 70)">Add +</button></span></div>
                        </div>
                    </div>
                    <div id="nonvegList" style="display:none;">
                        <div class="box"><h2>🌶️ Spicy & Chatpata - Non-Veg</h2>
                            <div class="item"><div class="left"><img src="https://www.gamintraveler.com/wp-content/uploads/2024/08/Pani-Puri.jpg"><span>Chicken Keema Pani Puri<span class="rateSmall" onclick="openRate('Chicken Pani Puri')">⭐ 4.9 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹110</span><button class="addBtn" onclick="addToCart('Chicken Pani Puri', 110)">Add +</button></span></div>
                            <div class="item"><div class="left"><img src="https://c.ndtvimg.com/2024-06/eebcuqqg_bhel-puri_625x300_27_June_24.jpg?im=FaceCrop"><span>Chicken Bhel Puri<span class="rateSmall" onclick="openRate('Chicken Bhel')">⭐ 4.7 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹120</span><button class="addBtn" onclick="addToCart('Chicken Bhel', 120)">Add +</button></span></div>
                        </div>
                        <div class="box"><h2>🍔 Street Food - Non-Veg</h2>
                            <div class="item"><div class="left"><img src="https://www.kuchpakrahahai.in/wp-content/uploads/2026/02/veg-momos-recipe.jpg"><span>Chicken Momos (8 pc)<span class="rateSmall" onclick="openRate('Chicken Momos')">⭐ 4.9 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹130</span><button class="addBtn" onclick="addToCart('Chicken Momos', 130)">Add +</button></span></div>
                            <div class="item"><div class="left"><img src="https://ministryofcurry.com/wp-content/uploads/2020/05/chicken-kathi-rolls.jpg"><span>Chicken Roll<span class="rateSmall" onclick="openRate('Chicken Roll')">⭐ 4.8 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹130</span><button class="addBtn" onclick="addToCart('Chicken Roll', 130)">Add +</button></span></div>
                        </div>
                        <div class="box"><h2>🍕 Main Course - Non-Veg</h2>
                            <div class="item"><div class="left"><img src="https://masaladiaries.com/wp-content/uploads/2025/08/indian-chicken-biryani-restaurant-style-683x1024.jpg"><span>Chicken Biryani<span class="rateSmall" onclick="openRate('Chicken Biryani')">⭐ 5.0 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹220</span><button class="addBtn" onclick="addToCart('Chicken Biryani', 220)">Add +</button></span></div>
                            <div class="item"><div class="left"><img src="https://cdn.loveandlemons.com/wp-content/uploads/opengraph/2023/02/vegetarian-pizza-recipe.jpg"><span>Chicken Pizza<span class="rateSmall" onclick="openRate('Chicken Pizza')">⭐ 4.8 - Rate</span></span></div><span style="text-align:right;"><span class="price">₹280</span><button class="addBtn" onclick="addToCart('Chicken Pizza', 280)">Add +</button></span></div>
                        </div>
                    </div>
                    <button class="floatCart" onclick="goPage(4)">🛒 View Cart - Rs <span id="cartTotalFloat">0</span></button>
                </div>

                <!-- PAGE 4 : CART -->
                <div id="page4" class="page">
                    <div class="topBar"><button class="backBtn" onclick="goPage(2)">← Home</button><b>🛒 My Cart</b><button class="backBtn" onclick="goPage(3)">← Menu</button></div>
                    <h1>Your Cart & Bill</h1>
                    <div class="box"><div id="cartList"></div><hr><p><b>Items:</b> <span id="popCount">0</span> | <b>Subtotal:</b> Rs <span id="popTotal">0</span></p><p><b>Delivery:</b> Rs 30 | <b>Total Bill:</b> Rs <span id="popGrand">0</span></p></div>
                    <div class="box"><h2>📦 Delivery Details</h2>
                        <input class="inputBox" id="custName" placeholder="Your Name - e.g. Neha">
                        <input class="inputBox" id="custPhone" placeholder="Phone Number - 9876543210">
                        <input class="inputBox" id="custAddress" placeholder="Full Address - Kolkata...">
                        <div class="payBox"><b>💳 Payment Method:</b><br>
                          <label><input type="radio" name="pay" value="Cash on Delivery" checked> 💵 Cash on Delivery</label><br>
                          <label><input type="radio" name="pay" value="UPI"> 📱 UPI - GPay / PhonePe</label><br>
                          <label><input type="radio" name="pay" value="Card"> 💳 Debit / Credit Card</label>
                        </div>
                        <button class="greenBtn" onclick="placeOrder()">✅ Place Order</button>
                        <button class="greenBtn" style="background:#D32F2F" onclick="clearCart()">🗑️ Clear Cart</button>
                    </div>
                    <div class="box" id="trackBox" style="display:none;">
                        <h2>🎉 Order Placed!</h2><p id="trackInfo"></p>
                        <div id="step1" class="trackStep trackActive">✅ Order Confirmed</div>
                        <div id="step2" class="trackStep">👨‍🍳 Preparing Your Food...</div>
                        <div id="step3" class="trackStep">🛵 Out For Delivery...</div>
                        <div id="step4" class="trackStep">🏠 Delivered - Enjoy Your Meal!</div>
                        <p id="trackTimer" style="font-weight:bold; color:#D32F2F;">Estimated Time: 30 mins</p>
                        <button class="greenBtn" onclick="openRate('Your Order')">⭐ Rate Your Order</button>
                    </div>
                </div>

                <!-- RATING POPUP -->
                <div id="ratePopup" style="display:none; position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0,0,0,0.6); z-index:100;">
                  <div style="background:white; max-width:400px; margin:80px auto; padding:20px; border-radius:20px; text-align:center;">
                    <button style="float:right; background:#eee; border:none; padding:8px 12px; border-radius:12px; cursor:pointer;" onclick="closeRate()">✖</button>
                    <h2 id="rateTitle">Rate This Food</h2>
                    <div class="stars" id="starBox"><span onclick="setStar(1)">☆</span><span onclick="setStar(2)">☆</span><span onclick="setStar(3)">☆</span><span onclick="setStar(4)">☆</span><span onclick="setStar(5)">☆</span></div>
                    <p id="rateMsg" style="font-weight:bold; color:#D32F2F;"></p>
                    <button class="greenBtn" onclick="submitRate()">Submit Rating</button>
                  </div>
                </div>

                <script>
                let cart = []; let orders = []; let currentRateItem=''; let selectedStar=0;
                function goPage(n){
                  document.getElementById('page1').style.display='none';
                  document.getElementById('page2').style.display='none';
                  document.getElementById('page3').style.display='none';
                  document.getElementById('page4').style.display='none';
                  document.getElementById('page'+n).style.display='block';
                  window.scrollTo(0,0);
                  if(n==4) updateCart();
                }
                function doLogin(){
                  let n=document.getElementById('loginName').value.trim();
                  let ph=document.getElementById('loginPhone').value.trim();
                  if(n==='' || ph===''){ alert('Please enter Name and Phone!'); return; }
                  document.getElementById('welcomeText').innerText='👋 Hi, '+n+'!';
                  document.getElementById('custName').value=n;
                  document.getElementById('custPhone').value=ph;
                  goPage(2);
                }
                function skipLogin(){
                  document.getElementById('welcomeText').innerText='👋 Hi, Guest!';
                  goPage(2);
                }
                function logout(){ goPage(1); }
                function openFood(type){
                  if(type=='veg'){ document.getElementById('vegList').style.display='block'; document.getElementById('nonvegList').style.display='none'; document.getElementById('foodTitle').innerText='Veg Menu'; document.getElementById('foodHeading').innerText='🟢 Veg Menu'; }
                  else { document.getElementById('vegList').style.display='none'; document.getElementById('nonvegList').style.display='block'; document.getElementById('foodTitle').innerText='Non-Veg Menu'; document.getElementById('foodHeading').innerText='🔴 Non-Veg Menu'; }
                  goPage(3);
                }
                function addToCart(name,price){ let f=cart.find(i=>i.name===name); if(f) f.qty++; else cart.push({name:name,price:price,qty:1}); updateCart(); alert(name+' Added!'); }
                function updateCart(){ let c=0,t=0; cart.forEach(i=>{c+=i.qty; t+=i.price*i.qty;}); document.getElementById('cartCount2').innerText=c; document.getElementById('cartTotalFloat').innerText=t; document.getElementById('popCount').innerText=c; document.getElementById('popTotal').innerText=t; document.getElementById('popGrand').innerText=t+(c>0?30:0); let h=''; if(cart.length===0) h='<p>Your cart is empty!</p>'; cart.forEach((i,idx)=>{ h+='<div class="cartRow"><span>'+i.name+' x '+i.qty+'</span><span>Rs '+(i.price*i.qty)+' <button onclick="removeItem('+idx+')">❌</button></span></div>'; }); document.getElementById('cartList').innerHTML=h; }
                function removeItem(idx){ cart.splice(idx,1); updateCart(); }
                function clearCart(){ cart=[]; updateCart(); alert('Cart cleared!'); }
                function placeOrder(){ let name=document.getElementById('custName').value; let phone=document.getElementById('custPhone').value; let addr=document.getElementById('custAddress').value; let pay=document.querySelector('input[name="pay"]:checked').value; if(cart.length===0){ alert('Your cart is empty!'); return; } if(!name||!phone||!addr){ alert('Please enter Name, Phone and Address!'); return; } let total=document.getElementById('popGrand').innerText; let itemsText=cart.map(i=>i.name+' x '+i.qty).join(', '); orders.push({items:itemsText,total:total,name:name,pay:pay,time:new Date().toLocaleTimeString()}); updateHistory(); document.getElementById('trackInfo').innerHTML='<b>Name:</b> '+name+'<br><b>Items:</b> '+itemsText+'<br><b>Total:</b> Rs '+total+'<br><b>Payment:</b> '+pay+'<br><b>Address:</b> '+addr; cart=[]; updateCart(); document.getElementById('trackBox').style.display='block'; startTracking(); window.scrollTo(0,0); }
                function startTracking(){ document.getElementById('step1').className='trackStep trackActive'; document.getElementById('step2').className='trackStep'; document.getElementById('step3').className='trackStep'; document.getElementById('step4').className='trackStep'; setTimeout(()=>{ document.getElementById('step2').className='trackStep trackActive'; document.getElementById('trackTimer').innerText='Estimated Time: 20 mins - Cooking!'; },5000); setTimeout(()=>{ document.getElementById('step3').className='trackStep trackActive'; document.getElementById('trackTimer').innerText='Estimated Time: 10 mins - Rider is on the way!'; },10000); setTimeout(()=>{ document.getElementById('step4').className='trackStep trackActive'; document.getElementById('trackTimer').innerText='Delivered! Enjoy your meal'; },15000); }
                function updateHistory(){ let h=''; orders.forEach((o,idx)=>{ h+='<div class="historyBox"><b>Order '+(idx+1)+' - '+o.time+'</b><br>'+o.items+'<br>Total: Rs '+o.total+' | '+o.pay+'</div>'; }); document.getElementById('historyList').innerHTML=h; }
                function openRate(item){ currentRateItem=item; selectedStar=0; document.getElementById('rateTitle').innerText='Rate - '+item; document.getElementById('rateMsg').innerText=''; document.getElementById('starBox').innerHTML='<span onclick="setStar(1)">☆</span><span onclick="setStar(2)">☆</span><span onclick="setStar(3)">☆</span><span onclick="setStar(4)">☆</span><span onclick="setStar(5)">☆</span>'; document.getElementById('ratePopup').style.display='block'; }
                function closeRate(){ document.getElementById('ratePopup').style.display='none'; }
                function setStar(n){ selectedStar=n; let s=document.getElementById('starBox').children; let m=['','Bad','Okay','Good','Great','Amazing!']; for(let i=0;i<5;i++){ s[i].innerText=(i<n?'★':'☆'); } document.getElementById('rateMsg').innerText=m[n]+' - '+n+' Star!'; }
                function submitRate(){ if(selectedStar===0){ alert('Please tap a star first!'); return; } alert('Thank you! You gave '+selectedStar+' stars to '+currentRateItem); closeRate(); }
                function doSearch(){ let q=document.getElementById('searchBox').value.toLowerCase(); if(q.length>1){ openFood(q.includes('chicken')||q.includes('egg')?'nonveg':'veg'); document.getElementById('searchBox2').value=q; doSearch2(); } }
                function doSearch2(){ let q=document.getElementById('searchBox2').value.toLowerCase(); let items=document.querySelectorAll('#page3 .item'); items.forEach(it=>{ let t=it.innerText.toLowerCase(); it.style.display=t.includes(q)?'flex':'none'; }); }
                </script>
                </body>
                </html>
                """;
    }
}