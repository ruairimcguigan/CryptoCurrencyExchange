/**
 * Contains common classes used throughout the ui package.
 *
 * Question:
 * Why is FragmentManager injected into the BaseActivity? Why not just use
 * the getFragmentManager()method?
 *
 * Answer:
 * This relates to mocking and verification in unit tests. In the MVP Passive View
 * adaptation of this project, Activities and Fragments should not contain any logic
 * or enough logic to warrant unit tests. However, there may be some cases that unit testing
 * the Activity / Fragment is worth it. In such cases, we want to be able to mock every single
 * dependency of the Activity / Fragment. Thus, references to Context and FragmentManager are
 * injected and used in Activities / Fragments instead of their getter method counterparts
 * (getContext(), getFragmentManager(), or getChildFragmentManager()). This enables Mockito to
 * easily inject mocked versions of these dependencies (via field injection of @InjectMocks)
 * for mocking and verification in unit tests.
 */
package exchange.currency.crypto.com.cryptocurrencyexchange.ui.common;
