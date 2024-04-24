package com.example.arzagplusui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.arzagplusui.ui.theme.ArzagPlusUITheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        val categories = listOf(
            Category("1","العروض",getString(R.string.Link1)),
            Category("2","اللحوم والدواجن",getString(R.string.Link2)),
            Category("3","البحريات",getString(R.string.Link3)),
            Category("4","الزبدة والزيت",getString(R.string.Link4)),
            Category("5","البطاطس والمقبلات",getString(R.string.Link5)),
            Category("6","الصلصات",getString(R.string.Link6)),
            Category("7","الأجبان",getString(R.string.Link7)),
            Category("8","الحليب والكريمة",getString(R.string.Link8)),
            Category("9","المنكهات والمشروبات",getString(R.string.Link9)),
            Category("10","المخبوزات ولوازم الكيك",getString(R.string.Link10)),
            Category("11","الحلويات والايسكريم",getString(R.string.Link11)),
            Category("12","المربى والعسل",getString(R.string.Link12)),
            Category("13","الخضراوات والفواكه",getString(R.string.Link13)),
            Category("14","الارز والمعكرونة",getString(R.string.Link14)),
            Category("15","البهارات والمخللات",getString(R.string.Link15)),
            Category("16","المنظفات والبلاستيك",getString(R.string.Link16))
        )

        val products = listOf(
            Product("1","داري جبن حلوم","https://cdnprod.mafretailproxy.com/sys-master-root/h54/h7e/10371964207134/553705_main.jpg_480Wx480H","225 x 20 جم",235.75f),
            Product("2","فيلادلفيا جبنة كريمة طرية","https://jomla.me/wp-content/uploads/2023/07/Philadelphia-Cheese-Cream-Case-4-X-1.65Kg.jpg","4 x 1.65 كجم",242.4f)
        )

        val productsLong = listOf(
            Product("1","داري جبن حلوم","https://cdnprod.mafretailproxy.com/sys-master-root/h54/h7e/10371964207134/553705_main.jpg_480Wx480H","225 x 20 جم",235.75f,"الاجبان"),
            Product("1","داري جبن حلوم","https://cdnprod.mafretailproxy.com/sys-master-root/h54/h7e/10371964207134/553705_main.jpg_480Wx480H","225 x 20 جم",235.75f,"الحليب"),
            Product("1","داري جبن حلوم","https://cdnprod.mafretailproxy.com/sys-master-root/h54/h7e/10371964207134/553705_main.jpg_480Wx480H","225 x 20 جم",235.75f,"مستلزمات الشوي"),
            Product("1","داري جبن حلوم","https://cdnprod.mafretailproxy.com/sys-master-root/h54/h7e/10371964207134/553705_main.jpg_480Wx480H","225 x 20 جم",235.75f,"الاجبان"),
            Product("1","داري جبن حلوم","https://cdnprod.mafretailproxy.com/sys-master-root/h54/h7e/10371964207134/553705_main.jpg_480Wx480H","225 x 20 جم",235.75f,"الاجبان"),
            Product("2","فيلادلفيا جبنة كريمة طرية","https://jomla.me/wp-content/uploads/2023/07/Philadelphia-Cheese-Cream-Case-4-X-1.65Kg.jpg","4 x 1.65 كجم",242.4f,"الكيك")
        )

        val slider = listOf(
            "https://img.freepik.com/free-vector/flat-design-fast-food-facebook-template_23-2149135961.jpg?size=626&ext=jpg&ga=GA1.1.1700460183.1712880000&semt=ais",
            "https://images.template.net/17352/food-restaurant-facebook-ad-banner-templates-edit-online.jpg",
            "https://png.pngtree.com/png-clipart/20220730/original/pngtree-burger-fast-food-gourmet-fast-food-catering-promotion-web-banner-png-image_8443719.png"
        )
        super.onCreate(savedInstanceState)
        setContent {
            ArzagPlusUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Box (modifier = Modifier.fillMaxSize()){
                        val scrollState = rememberScrollState()
                        Column (modifier = Modifier
                            .verticalScroll(scrollState)
                            .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Spacer(modifier = Modifier.padding(60.dp)) //original Spacer for the topHead
                            ImageSliderCard(slider) //Image Slider
                            Spacer(modifier = Modifier.padding(5.dp))
                            //2 Cells
                            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
                                StatusItem(header = "الطلبات السابقة", description = "اعادة الطلب","https://upload.wikimedia.org/wikipedia/commons/b/bc/Refresh_icon.png")
                                StatusItem(header = "رصيد نقاطك", description = "نقاط ارزاق","https://w7.pngwing.com/pngs/620/331/png-transparent-red-star-five-pointed-star-icon-star-angle-orange-triangle-thumbnail.png")
                            }
                            Spacer(modifier = Modifier.padding(5.dp))

                            //Category Cells
                            ExpandableProductGrid(categories = categories)
                            Spacer(modifier = Modifier.padding(5.dp))
                            Column(horizontalAlignment = Alignment.End) {
                                Text(text = "المنتجات المقترحة", modifier = Modifier.padding(10.dp),
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.padding(5.dp))
                                HoriztalScrollProductList(products)
                            }
                            Spacer(modifier = Modifier.padding(10.dp))

                            Section ("https://cdn-icons-png.freepik.com/512/891/891448.png","منتجات جديدة") { HoriztalScrollProductListLong(productsLong) }
                            Spacer(modifier = Modifier.padding(10.dp))

                            Section ("https://static-00.iconduck.com/assets.00/chef-hat-icon-512x511-nutd9h64.png","اختيارات الشيف") { HoriztalScrollProductListLongCat(productsLong) }
                            Spacer(modifier = Modifier.padding(10.dp))

                            OfferSlider(pictures = slider)
                            Spacer(modifier = Modifier.padding(15.dp))

                            Section ("https://static-00.iconduck.com/assets.00/coffee-icon-2048x2048-plv1v89d.png","مستلزمات المقاهي") { HoriztalScrollProductListLongCat(productsLong) }
                            Spacer(modifier = Modifier.padding(10.dp))

                            //Bottom spacer for the navbar
                            Spacer(modifier = Modifier.padding(30.dp))
                        }

                            TopHead(destination = "Dammam",
                                Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.18f))
                            
                            BottomNavBar()
                    }
                }
            }
        }
    }
}

@Composable
fun ExpandableProductGrid(categories: List<Category>) {
    var showAll by remember { mutableStateOf(false) }

    // This will control the number of items to show. If showAll is true, it will show all products.
    // Otherwise, it will only show the first 8 or less if there are not enough products.
    val itemsToShow = if (showAll || categories.size <= 8) categories else categories.take(8)

    // LazyVerticalGrid is used to create a grid layout.


    // Button to expand or collapse the grid.
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Card (colors = CardDefaults.cardColors(Color.White), elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)) {
            Column {
                LazyVerticalGrid(
                    userScrollEnabled = false,
                    columns = GridCells.Fixed(4),
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier
                        .height(if (showAll || categories.size <= 8) 550.dp else 280.dp)
                        .fillMaxWidth()
                        .animateContentSize()
                ) {
                    items(itemsToShow.size) { index ->
                        CategoryItem(category = itemsToShow[index])
                    }
                }



                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp)
                    .background(Color.Transparent, RoundedCornerShape(5.dp))
                    .align(Alignment.CenterHorizontally)
                    .clickable { showAll = !showAll }
                    , contentAlignment = Alignment.Center
                ) {
                    Text(if (showAll) "↑" else "↓", fontSize = 30.sp)
                }
            }
        }


    }
}
@Composable
fun CategoryItem(category: Category) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { }
    ) {
        Image(
            painter = rememberImagePainter(
                data = category.imageUrl,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = "Product Image",
            modifier = Modifier
                .size(60.dp) // This sets both width and height to 128.dp
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally), // This will clip the image into a circle shape
            contentScale = ContentScale.Inside // This will fill the bounds and crop the excess
        )
        Text(
            text = category.name,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 4.dp),
            textAlign = TextAlign.Center,
            fontSize = 19.sp
        )
        // Add more product details below
    }
}
@Composable
fun BottomShadowCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(topEnd = 0.dp, topStart = 0.dp, bottomEnd = 15.dp, bottomStart = 15.dp)// The elevation here creates the shadow effect.
    ) {
        Box {
            content()
            // Shadow overlay box
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.2f) // The alpha value controls the shadow intensity.
                            ),
                            startY = 200f, // Start point of the gradient. Adjust if necessary.
                            endY = 500f // End point of the gradient. Adjust to control the height of the shadow.
                        )
                    )
            )
        }
    }
}
@Composable
fun StatusItem(header: String, description: String, imgURL: String = ""){

    Card (shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(defaultElevation = 1.dp), modifier = Modifier.clickable {  }, colors = CardDefaults.cardColors(Color.White)) {
        Row(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, end = 25.dp, start = 25.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = rememberImagePainter(
                    data = imgURL,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(40.dp) // This sets both width and height to 128.dp
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically), // This will clip the image into a circle shape
                contentScale = ContentScale.Crop // This will fill the bounds and crop the excess
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = header, color = Color.Gray, fontSize = 12.sp, textAlign = TextAlign.Center)
                Text(text = description, fontWeight = FontWeight.Bold, fontSize = 17.sp)
            }
        }
    }

}
@Composable
fun TopHead(destination: String, modifier: Modifier = Modifier){
        BottomShadowCard {
            Box(modifier = Modifier
                .fillMaxHeight(0.16f)
                .fillMaxWidth()
                .background(Color.White)
                .clickable { })
        }

        Column ( modifier = modifier.fillMaxSize(),verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
            Card(modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(40.dp)
                .padding(2.dp)
                .clickable { }
            , elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            , colors = CardDefaults.cardColors(Color.White)) {
                Row (horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(end = 10.dp, start = 10.dp)) {
                    Image(
                        painter = rememberImagePainter(
                            data = "https://uxwing.com/wp-content/themes/uxwing/download/user-interface/search-icon.png",
                            builder = {
                                crossfade(true)
                            }
                        ),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .size(25.dp) // This sets both width and height to 128.dp

                            .align(Alignment.CenterVertically), // This will clip the image into a circle shape
                        contentScale = ContentScale.Crop // This will fill the bounds and crop the excess
                    )
                    Text(text = "ابحث عن منتج او براند")
                }
            }

        }

        Column (modifier = modifier
            .fillMaxSize()
            .padding(15.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.End) {
            Text(text = "التوصيل إلى", color = Color.Red)
            Row {
                Text(text = destination, modifier = Modifier.padding(end = 5.dp, start = 5.dp))
                Image(
                    painter = rememberImagePainter(
                        data = "https://png.pngtree.com/png-clipart/20220521/ourmid/pngtree-red-location-icon-sign-png-image_4644037.png",
                        builder = {
                            crossfade(true)
                        }
                    ),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .size(15.dp) // This sets both width and height to 128.dp

                        .align(Alignment.CenterVertically), // This will clip the image into a circle shape
                    contentScale = ContentScale.Crop // This will fill the bounds and crop the excess
                )
            }
        }
}
@Composable
fun ImageSlider(images: List<String>, interval: Long = 3000) {
    val scope = rememberCoroutineScope()
    val state = rememberLazyListState()
    val maxIndex = images.size - 1

    LaunchedEffect(key1 = state) {
        var currentIndex = 0
        while (true) {
            delay(interval)
            currentIndex = if (currentIndex < maxIndex) currentIndex + 1 else 0
            state.animateScrollToItem(currentIndex)
        }
    }

    LazyRow(state = state) {
        items(images.size) { index ->
            Image(
                painter = rememberImagePainter(images[index]),
                contentDescription = "Image $index",
                modifier = Modifier.fillParentMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}
@Composable
fun ImageSliderCard(images: List<String>, interval: Long = 3000) {
    // This is the card that will be shown on top of the image slider.
    @Composable
    fun TopCard() {
        Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom, modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(16.dp)
                    ,
                // Adjust padding as needed
                elevation = CardDefaults.cardElevation(1.dp) ,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                colors = CardDefaults.cardColors(Color.White)// Adjust the corner size as needed
            ) {
                Text(text = "أفضل عروضنا",modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            }
        }

    }

    Box {
        Card(
            elevation = CardDefaults.cardElevation(3.dp),
            shape = RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp), // Rounded bottom corners
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            ImageSlider(images = images, interval = interval)
        }
        TopCard() // This card will overlay on top of the slider
    }
}
@Composable
fun HorizontalProductItem(product: Product){
    Card(

        elevation = CardDefaults.elevatedCardElevation(1.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier.clickable {  }

    ){
        Row(
            modifier = Modifier
                .width(325.dp)
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically


        ) {
            Image(
                painter = rememberImagePainter(
                    data = product.imageUrl,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(120.dp) // This sets both width and height to 128.dp
                    .clip(RoundedCornerShape(10.dp))
                    .align(Alignment.CenterVertically), // This will clip the image into a circle shape
                contentScale = ContentScale.Inside // This will fill the bounds and crop the excess
            )
            //Spacer(modifier = Modifier.padding(5.dp))
            Column(

                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp)
                Card(
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.elevatedCardElevation(2.dp),
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = product.specification,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(2.dp))
                }
                Text(text = "${product.price} ر.س",
                    fontSize = 16.sp,
                    color = Color.Red)
                Text(text = "شامل الضريبة",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    fontSize = 10.sp)
            }
        }
    }
}
@Composable
fun HoriztalScrollProductList(products: List<Product>){
    LazyRow{
        items(products) { product ->
            Spacer(modifier = Modifier.padding(5.dp))
            HorizontalProductItem(product = product)
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}
@Composable
fun HoriztalScrollProductListLong(products: List<Product>){
    LazyRow(

    ) {
        items(products) { product ->
            Spacer(modifier = Modifier.padding(5.dp))
            VerticalProductCell(product = product)
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}
@Composable
fun HoriztalScrollProductListLongCat(products: List<Product>){
    LazyRow(

    ) {
        items(products) { product ->
            Spacer(modifier = Modifier.padding(5.dp))
            ProductWithCategory(product = product)
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }
}
@Composable
fun BottomNavBar(){
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .fillMaxHeight(0.08f)
            .fillMaxWidth()
            .background(
                Color.White,
                RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
            ),

        )
        {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(end = 10.dp, start = 10.dp)
            ) {
                NavItem(NavigationItem.Cart)
                NavItem(NavigationItem.Home)
                NavItem(NavigationItem.Settings)
            }
        }
    }

}
@Composable
fun NavItem(item: NavigationItem){
    Column(modifier = Modifier
        .fillMaxHeight()
        .width(100.dp)
        .clickable { },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(painter = painterResource(id = item.icon), contentDescription = item.title, modifier = Modifier.size(25.dp))
        Text(text = item.title)
    }
}
@Composable
fun VerticalProductCell(product: Product){

    Card(
        elevation = CardDefaults.elevatedCardElevation(2.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier.clickable {  }

    ){
        Column(

            modifier = Modifier
                .width(150.dp)
                .height(245.dp)
                .padding(end = 5.dp, start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Spacer(modifier = Modifier.padding(10.dp))

            Image(
                painter = rememberImagePainter(
                    data = product.imageUrl,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(100.dp) // This sets both width and height to 128.dp
                    .clip(RoundedCornerShape(10.dp))
                    .align(Alignment.CenterHorizontally), // This will clip the image into a circle shape
                contentScale = ContentScale.Inside // This will fill the bounds and crop the excess
            )
                Spacer(modifier = Modifier.padding(10.dp))

                Text(text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp)
                Card(
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.elevatedCardElevation(2.dp),
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = product.specification,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(2.dp))
                }
                Text(text = "${product.price} ر.س",
                    fontSize = 14.sp,
                    color = Color.Red)
                Text(text = "شامل الضريبة",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    fontSize = 10.sp)
            Spacer(modifier = Modifier.padding(5.dp))
            }

    }

}
@Composable
fun Section(iconURL: String, headerText: String, content: @Composable () -> Unit){
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Card(
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier.padding(5.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp)
            ) {
                Text(text = headerText,
                    modifier = Modifier
                        .padding(10.dp),
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End)

                Image(
                    painter = rememberImagePainter(
                        data = iconURL,
                        builder = {
                            crossfade(true)
                        }
                    ),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .size(30.dp) // This sets both width and height to 128.dp
                        .clip(RoundedCornerShape(10.dp))
                        .align(Alignment.CenterVertically), // This will clip the image into a circle shape
                    contentScale = ContentScale.Inside // This will fill the bounds and crop the excess
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            content()
            Spacer(modifier = Modifier.padding(8.dp))

        }
    }
}
@Composable
fun ProductWithCategory(product: Product){
    Box {
        VerticalProductCell(product)
        Column(modifier = Modifier.width(150.dp)) {
            Card(
                elevation = CardDefaults.elevatedCardElevation(4.dp),
                shape = RoundedCornerShape(bottomStart = 15.dp),
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 10.dp, start = 10.dp)) {
                    Text(text = "←", fontSize = 22.sp,  color = Color.Red)
                    Text(text = product.category)
                }
                
            }
        }
    }
}
@Composable
fun OfferSlider(pictures: List<String>){
    LazyRow{
        items(pictures) { picture ->
            Spacer(modifier = Modifier.padding(5.dp))
            Card(modifier = Modifier
                .width(325.dp)
                .height(130.dp),
                elevation = CardDefaults.elevatedCardElevation(1.dp)) {
                Image(
                    painter = rememberImagePainter(
                        data = picture,
                        builder = {
                            crossfade(true)
                        }
                    ),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .fillMaxWidth() // This sets both width and height to 128.dp
                        .clip(RoundedCornerShape(10.dp)), // This will clip the image into a circle shape
                    contentScale = ContentScale.Crop // This will fill the bounds and crop the excess
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
        }
    }

}

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("الرئيسية", R.drawable.ic_home, "الرئيسية")
    object Cart : NavigationItem("السلة", R.drawable.ic_cart, "السلة")
    object Settings : NavigationItem("الاغدادات", R.drawable.ic_settings, "الاعدادات")
}