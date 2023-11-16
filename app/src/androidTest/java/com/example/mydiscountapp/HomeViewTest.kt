import androidx.activity.viewModels
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.mydiscountapp.viewModel.CalculateViewModel
import com.example.mydiscountapp.views.HomeView
import org.junit.Rule
import org.junit.Test

class HomeViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeView_CalculatesCorrectly() {
        val viewModel = CalculateViewModel ()
        composeTestRule.setContent {
           HomeView(viewModel = viewModel) // Renderizar la vista
        }

        // Encontrar los campos de entrada de texto
        val priceTextField = composeTestRule.onNodeWithTag("Precio")
        val discountTextField = composeTestRule.onNodeWithTag("Descuento")

        // Ingresar valores en los campos de entrada de texto
        priceTextField.performClick()
        priceTextField.performTextInput("100") // Ingresa un valor de precio
        discountTextField.performClick()
        discountTextField.performTextInput("10")  // Ingresa un valor de descuento

        // Encontrar y hacer clic en el botón "Calcular"
        val calculateButton = composeTestRule.onNodeWithText("Calcular")
        calculateButton.performClick()
        val priceWithDiscountCard = composeTestRule.onNodeWithText("$90.0")
        priceWithDiscountCard.assertExists()

        val totalDiscountCard = composeTestRule.onNodeWithText("$10.0")
        totalDiscountCard.assertExists()

    }
}
