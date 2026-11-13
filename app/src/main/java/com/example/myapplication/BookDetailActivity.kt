package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.Book
import com.example.myapplication.ui.theme.MyApplicationTheme

class BookDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val book = fromIntent(intent)

        setContent {
            MyApplicationTheme {
                BookDetailScreen(
                    book = book,
                    onBack = { finish() }
                )
            }
        }
    }

    companion object {
        private const val EXTRA_TITLE = "extra_book_title"
        private const val EXTRA_AUTHOR = "extra_book_author"
        private const val EXTRA_PUBLISHER = "extra_book_publisher"
        private const val EXTRA_PRICE = "extra_book_price"
        private const val EXTRA_PUBLISH_YEAR = "extra_book_publish_year"
        private const val EXTRA_ISBN = "extra_book_isbn"
        private const val EXTRA_PAGE_COUNT = "extra_book_page_count"
        private const val EXTRA_DESCRIPTION = "extra_book_description"

        fun createIntent(context: Context, book: Book): Intent =
            Intent(context, BookDetailActivity::class.java).apply {
                putExtra(EXTRA_TITLE, book.title)
                putExtra(EXTRA_AUTHOR, book.author)
                putExtra(EXTRA_PUBLISHER, book.publisher)
                putExtra(EXTRA_PRICE, book.price)
                putExtra(EXTRA_PUBLISH_YEAR, book.publishYear)
                putExtra(EXTRA_ISBN, book.isbn)
                putExtra(EXTRA_PAGE_COUNT, book.pageCount)
                putExtra(EXTRA_DESCRIPTION, book.description)
            }

        private fun fromIntent(intent: Intent): Book = Book(
            title = intent.getStringExtra(EXTRA_TITLE).orEmpty(),
            author = intent.getStringExtra(EXTRA_AUTHOR).orEmpty(),
            publisher = intent.getStringExtra(EXTRA_PUBLISHER).orEmpty(),
            price = intent.getDoubleExtra(EXTRA_PRICE, 0.0),
            publishYear = intent.getIntExtra(EXTRA_PUBLISH_YEAR, 0),
            isbn = intent.getStringExtra(EXTRA_ISBN).orEmpty(),
            pageCount = intent.getIntExtra(EXTRA_PAGE_COUNT, 0),
            description = intent.getStringExtra(EXTRA_DESCRIPTION).orEmpty()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BookDetailScreen(
    book: Book,
    onBack: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.detail_title),
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text(
                            text = stringResource(R.string.back),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BookHeaderCard(book = book)
            BookInfoCard(book = book)
            BookDescriptionCard(description = book.description)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
private fun BookHeaderCard(book: Book) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(22.dp)) {
            Text(
                text = book.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.author_format, book.author),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = stringResource(R.string.price_format, book.price),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun BookInfoCard(book: Book) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
            InfoRow(
                label = stringResource(R.string.book_title),
                value = book.title
            )
            InfoDivider()
            InfoRow(
                label = stringResource(R.string.book_author),
                value = book.author
            )
            InfoDivider()
            InfoRow(
                label = stringResource(R.string.book_publisher),
                value = book.publisher
            )
            InfoDivider()
            InfoRow(
                label = stringResource(R.string.book_price),
                value = stringResource(R.string.price_format, book.price)
            )
            InfoDivider()
            InfoRow(
                label = stringResource(R.string.book_publish_year),
                value = stringResource(R.string.year_format, book.publishYear)
            )
            InfoDivider()
            InfoRow(
                label = stringResource(R.string.book_isbn),
                value = book.isbn
            )
            InfoDivider()
            InfoRow(
                label = stringResource(R.string.book_page_count),
                value = stringResource(R.string.page_count_format, book.pageCount)
            )
        }
    }
}

@Composable
private fun InfoRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = label,
            modifier = Modifier.width(78.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun InfoDivider() {
    HorizontalDivider(
        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
    )
}

@Composable
private fun BookDescriptionCard(description: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = stringResource(R.string.book_description),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
