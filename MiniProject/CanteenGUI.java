package MiniProject;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class CanteenGUI extends JFrame {

    // ─── Color Palette ─────────────────────────────────────────────
    static final Color BG_DARK = new Color(18, 18, 30);
    static final Color BG_CARD = new Color(30, 30, 50);
    static final Color BG_CARD_HOVER = new Color(40, 40, 65);
    static final Color ACCENT_ORANGE = new Color(255, 140, 50);
    static final Color ACCENT_GREEN = new Color(80, 220, 130);
    static final Color ACCENT_BLUE = new Color(80, 160, 255);
    static final Color ACCENT_PINK = new Color(255, 100, 150);
    static final Color ACCENT_PURPLE = new Color(160, 100, 255);
    static final Color TEXT_PRIMARY = new Color(240, 240, 255);
    static final Color TEXT_SECONDARY = new Color(160, 160, 190);
    static final Color BORDER_COLOR = new Color(60, 60, 90);
    static final Color CART_BG = new Color(25, 25, 42);
    static final Color SUCCESS_GREEN = new Color(34, 197, 94);

    // ─── Fonts ──────────────────────────────────────────────────────
    static final Font FONT_TITLE = new Font("Segoe UI", Font.BOLD, 28);
    static final Font FONT_SUBTITLE = new Font("Segoe UI", Font.BOLD, 18);
    static final Font FONT_CATEGORY = new Font("Segoe UI", Font.BOLD, 15);
    static final Font FONT_ITEM = new Font("Segoe UI", Font.PLAIN, 14);
    static final Font FONT_PRICE = new Font("Segoe UI", Font.BOLD, 14);
    static final Font FONT_BUTTON = new Font("Segoe UI", Font.BOLD, 13);
    static final Font FONT_SMALL = new Font("Segoe UI", Font.PLAIN, 12);
    static final Font FONT_EMOJI = new Font("Segoe UI Emoji", Font.PLAIN, 28);

    // ─── Data Model ─────────────────────────────────────────────────
    static final String[][] CATEGORIES = {
            { "🍳 Tiffin", "🥗 Lunch", "🍽️ Dinner", "🍿 Snacks", "🥤 Beverages" },
    };
    static final String[][] TIFFIN_ITEMS = { { "Vada", "10" }, { "Dosa", "20" }, { "Idli", "30" }, { "Puri", "40" } };
    static final String[][] VEG_LUNCH = { { "Veg Biryani", "100" }, { "Dal", "50" }, { "Paneer", "150" },
            { "Curd", "100" } };
    static final String[][] NONVEG_LUNCH = { { "Chicken Biryani", "100" }, { "Mutton Biryani", "50" },
            { "Fish Biryani", "150" } };
    static final String[][] DINNER_ITEMS = { { "Veg Biryani", "100" }, { "Dal", "50" }, { "Chicken Biryani", "150" },
            { "Curd", "100" } };
    static final String[][] SNACK_ITEMS = { { "Chips", "100" }, { "Chocolates", "50" }, { "Biscuits", "150" },
            { "Cookies", "100" } };
    static final String[][] BEVERAGE_ITEMS = { { "Coke", "100" }, { "Fanta", "50" }, { "Pepsi", "150" },
            { "Sprite", "100" } };

    static final String[] CAT_EMOJIS = { "🍳", "🥗", "🍽️", "🍿", "🥤" };
    static final String[] CAT_NAMES = { "Tiffin", "Lunch", "Dinner", "Snacks", "Beverages" };
    static final Color[] CAT_COLORS = { ACCENT_ORANGE, ACCENT_GREEN, ACCENT_BLUE, ACCENT_PINK, ACCENT_PURPLE };

    // ─── State ──────────────────────────────────────────────────────
    private final ArrayList<String[]> cart = new ArrayList<>(); // {name, price}
    private int cartTotal = 0;

    // ─── UI Components ──────────────────────────────────────────────
    private CardLayout cardLayout;
    private JPanel contentPanel;
    private JLabel cartCountLabel;
    private JLabel cartTotalLabel;
    private DefaultListModel<String> cartListModel;

    // ═══════════════════════════════════════════════════════════════
    // CONSTRUCTOR
    // ═══════════════════════════════════════════════════════════════
    public CanteenGUI() {
        setTitle("🍴 Campus Canteen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(960, 680);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG_DARK);
        setLayout(new BorderLayout());

        // Card layout for switching panels
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setOpaque(false);

        // Build all views
        contentPanel.add(buildMainMenu(), "MAIN");
        contentPanel.add(buildCategoryPanel("Tiffin", TIFFIN_ITEMS, ACCENT_ORANGE, "🍳"), "TIFFIN");
        contentPanel.add(buildLunchPanel(), "LUNCH");
        contentPanel.add(buildCategoryPanel("Veg Lunch", VEG_LUNCH, ACCENT_GREEN, "🥬"), "VEG_LUNCH");
        contentPanel.add(buildCategoryPanel("Non-Veg Lunch", NONVEG_LUNCH, ACCENT_GREEN, "🍗"), "NONVEG_LUNCH");
        contentPanel.add(buildCategoryPanel("Dinner", DINNER_ITEMS, ACCENT_BLUE, "🍽️"), "DINNER");
        contentPanel.add(buildCategoryPanel("Snacks", SNACK_ITEMS, ACCENT_PINK, "🍿"), "SNACKS");
        contentPanel.add(buildCategoryPanel("Beverages", BEVERAGE_ITEMS, ACCENT_PURPLE, "🥤"), "BEVERAGES");
        contentPanel.add(buildCartPanel(), "CART");

        add(buildHeader(), BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // ═══════════════════════════════════════════════════════════════
    // HEADER
    // ═══════════════════════════════════════════════════════════════
    private JPanel buildHeader() {
        JPanel header = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(30, 30, 55), getWidth(), 0, new Color(50, 30, 70));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
                // Bottom glow line
                g2.setPaint(new GradientPaint(0, getHeight() - 3, ACCENT_ORANGE, getWidth(), getHeight() - 3,
                        ACCENT_PURPLE));
                g2.fillRect(0, getHeight() - 3, getWidth(), 3);
                g2.dispose();
            }
        };
        header.setPreferredSize(new Dimension(0, 70));
        header.setBorder(new EmptyBorder(10, 20, 10, 20));

        // Left: logo + title
        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        left.setOpaque(false);

        JLabel emoji = new JLabel("🍴");
        emoji.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 32));
        left.add(emoji);

        JLabel title = new JLabel("Campus Canteen");
        title.setFont(FONT_TITLE);
        title.setForeground(TEXT_PRIMARY);
        left.add(title);
        header.add(left, BorderLayout.WEST);

        // Right: cart button
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        right.setOpaque(false);

        cartCountLabel = new JLabel("0 items");
        cartCountLabel.setFont(FONT_SMALL);
        cartCountLabel.setForeground(TEXT_SECONDARY);
        right.add(cartCountLabel);

        cartTotalLabel = new JLabel("0");
        cartTotalLabel.setFont(FONT_PRICE);
        cartTotalLabel.setForeground(ACCENT_GREEN);
        right.add(cartTotalLabel);

        right.add(Box.createHorizontalStrut(5));

        JButton cartBtn = createStyledButton("🛒 Cart", ACCENT_ORANGE);
        cartBtn.addActionListener(e -> {
            refreshCartPanel();
            cardLayout.show(contentPanel, "CART");
        });
        right.add(cartBtn);

        JButton homeBtn = createStyledButton("🏠 Home", ACCENT_BLUE);
        homeBtn.addActionListener(e -> cardLayout.show(contentPanel, "MAIN"));
        right.add(homeBtn);

        header.add(right, BorderLayout.EAST);
        return header;
    }

    // ═══════════════════════════════════════════════════════════════
    // MAIN MENU VIEW
    // ═══════════════════════════════════════════════════════════════
    private JPanel buildMainMenu() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(BG_DARK);

        // Welcome banner
        JPanel banner = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(40, 25, 60), getWidth(), getHeight(),
                        new Color(25, 40, 55));
                g2.setPaint(gp);
                g2.fillRoundRect(15, 5, getWidth() - 30, getHeight() - 10, 20, 20);
                g2.dispose();
            }
        };
        banner.setOpaque(false);
        banner.setPreferredSize(new Dimension(0, 100));
        banner.setLayout(new GridBagLayout());
        JLabel welcomeLabel = new JLabel("What would you like to have today?");
        welcomeLabel.setFont(FONT_SUBTITLE);
        welcomeLabel.setForeground(TEXT_PRIMARY);
        banner.add(welcomeLabel);
        wrapper.add(banner, BorderLayout.NORTH);

        // Category grid
        JPanel grid = new JPanel(new GridLayout(1, 5, 15, 15));
        grid.setOpaque(false);
        grid.setBorder(new EmptyBorder(20, 30, 40, 30));

        String[] cardNames = { "TIFFIN", "LUNCH", "DINNER", "SNACKS", "BEVERAGES" };

        for (int i = 0; i < 5; i++) {
            final int idx = i;
            final String target = cardNames[i];
            JPanel card = new JPanel() {
                boolean hovered = false;
                {
                    setOpaque(false);
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            hovered = true;
                            repaint();
                        }

                        public void mouseExited(MouseEvent e) {
                            hovered = false;
                            repaint();
                        }

                        public void mouseClicked(MouseEvent e) {
                            cardLayout.show(contentPanel, target);
                        }
                    });
                }

                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    Color bg = hovered ? BG_CARD_HOVER : BG_CARD;
                    g2.setColor(bg);
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 24, 24);
                    // Accent top bar
                    g2.setColor(CAT_COLORS[idx]);
                    g2.fillRoundRect(0, 0, getWidth(), 6, 24, 24);
                    g2.fillRect(0, 3, getWidth(), 3);
                    if (hovered) {
                        g2.setColor(new Color(CAT_COLORS[idx].getRed(), CAT_COLORS[idx].getGreen(),
                                CAT_COLORS[idx].getBlue(), 30));
                        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 24, 24);
                    }
                    // Border
                    g2.setColor(hovered ? CAT_COLORS[idx] : BORDER_COLOR);
                    g2.setStroke(new BasicStroke(hovered ? 2f : 1f));
                    g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 24, 24);
                    g2.dispose();
                }
            };
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.setBorder(new EmptyBorder(35, 15, 25, 15));

            // Emoji
            JLabel emojiLbl = new JLabel(CAT_EMOJIS[idx]);
            emojiLbl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 48));
            emojiLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            card.add(emojiLbl);
            card.add(Box.createVerticalStrut(15));

            // Name
            JLabel nameLbl = new JLabel(CAT_NAMES[idx]);
            nameLbl.setFont(FONT_CATEGORY);
            nameLbl.setForeground(TEXT_PRIMARY);
            nameLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            card.add(nameLbl);
            card.add(Box.createVerticalStrut(8));

            // Item count
            int count = getItemCount(idx);
            JLabel countLbl = new JLabel(count + " items");
            countLbl.setFont(FONT_SMALL);
            countLbl.setForeground(TEXT_SECONDARY);
            countLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            card.add(countLbl);

            grid.add(card);
        }

        wrapper.add(grid, BorderLayout.CENTER);
        return wrapper;
    }

    private int getItemCount(int catIdx) {
        switch (catIdx) {
            case 0:
                return TIFFIN_ITEMS.length;
            case 1:
                return VEG_LUNCH.length + NONVEG_LUNCH.length;
            case 2:
                return DINNER_ITEMS.length;
            case 3:
                return SNACK_ITEMS.length;
            case 4:
                return BEVERAGE_ITEMS.length;
            default:
                return 0;
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // LUNCH SUB-MENU
    // ═══════════════════════════════════════════════════════════════
    private JPanel buildLunchPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG_DARK);

        panel.add(buildBackBar("Lunch", ACCENT_GREEN), BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(1, 2, 20, 20));
        grid.setOpaque(false);
        grid.setBorder(new EmptyBorder(40, 60, 60, 60));

        // Veg card
        grid.add(buildSubCategoryCard("🥬", "Veg Lunch", VEG_LUNCH.length + " items", ACCENT_GREEN,
                () -> cardLayout.show(contentPanel, "VEG_LUNCH")));
        // Non-veg card
        grid.add(buildSubCategoryCard("🍗", "Non-Veg Lunch", NONVEG_LUNCH.length + " items", ACCENT_ORANGE,
                () -> cardLayout.show(contentPanel, "NONVEG_LUNCH")));

        panel.add(grid, BorderLayout.CENTER);
        return panel;
    }

    private JPanel buildSubCategoryCard(String emoji, String title, String subtitle, Color accent, Runnable onClick) {
        JPanel card = new JPanel() {
            boolean hovered = false;
            {
                setOpaque(false);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                        hovered = true;
                        repaint();
                    }

                    public void mouseExited(MouseEvent e) {
                        hovered = false;
                        repaint();
                    }

                    public void mouseClicked(MouseEvent e) {
                        onClick.run();
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(hovered ? BG_CARD_HOVER : BG_CARD);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 24, 24);
                g2.setColor(accent);
                g2.fillRoundRect(0, 0, getWidth(), 6, 24, 24);
                g2.fillRect(0, 3, getWidth(), 3);
                if (hovered) {
                    g2.setColor(new Color(accent.getRed(), accent.getGreen(), accent.getBlue(), 25));
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 24, 24);
                }
                g2.setColor(hovered ? accent : BORDER_COLOR);
                g2.setStroke(new BasicStroke(hovered ? 2f : 1f));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 24, 24);
                g2.dispose();
            }
        };
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(new EmptyBorder(50, 20, 40, 20));

        JLabel emojiLbl = new JLabel(emoji);
        emojiLbl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 56));
        emojiLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(emojiLbl);
        card.add(Box.createVerticalStrut(18));

        JLabel titleLbl = new JLabel(title);
        titleLbl.setFont(FONT_SUBTITLE);
        titleLbl.setForeground(TEXT_PRIMARY);
        titleLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(titleLbl);
        card.add(Box.createVerticalStrut(8));

        JLabel subLbl = new JLabel(subtitle);
        subLbl.setFont(FONT_SMALL);
        subLbl.setForeground(TEXT_SECONDARY);
        subLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(subLbl);

        return card;
    }

    // ═══════════════════════════════════════════════════════════════
    // CATEGORY ITEM PANEL
    // ═══════════════════════════════════════════════════════════════
    private JPanel buildCategoryPanel(String categoryName, String[][] items, Color accent, String emoji) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG_DARK);

        // Determine back target
        String backTarget = "MAIN";
        if (categoryName.equals("Veg Lunch") || categoryName.equals("Non-Veg Lunch")) {
            backTarget = "LUNCH";
        }
        panel.add(buildBackBar(emoji + " " + categoryName, accent, backTarget), BorderLayout.NORTH);

        // Items grid
        JPanel grid = new JPanel(new GridLayout(0, 2, 15, 15));
        grid.setOpaque(false);
        grid.setBorder(new EmptyBorder(20, 30, 30, 30));

        String[] itemEmojis = getItemEmojis(categoryName);

        for (int i = 0; i < items.length; i++) {
            String name = items[i][0];
            int price = Integer.parseInt(items[i][1]);
            int tax = (int) Math.ceil(price * 0.12);
            int total = price + tax;
            String itemEmoji = (i < itemEmojis.length) ? itemEmojis[i] : "🍽️";

            JPanel card = new JPanel() {
                boolean hovered = false;
                {
                    setOpaque(false);
                    addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent e) {
                            hovered = true;
                            repaint();
                        }

                        public void mouseExited(MouseEvent e) {
                            hovered = false;
                            repaint();
                        }
                    });
                }

                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(hovered ? BG_CARD_HOVER : BG_CARD);
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
                    g2.setColor(hovered ? accent : BORDER_COLOR);
                    g2.setStroke(new BasicStroke(1f));
                    g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 18, 18);
                    g2.dispose();
                }
            };
            card.setLayout(new BorderLayout(15, 0));
            card.setBorder(new EmptyBorder(18, 20, 18, 20));

            // Left side: emoji + info
            JPanel info = new JPanel();
            info.setOpaque(false);
            info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

            JLabel emojiLabel = new JLabel(itemEmoji);
            emojiLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
            emojiLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            info.add(emojiLabel);
            info.add(Box.createVerticalStrut(6));

            JLabel nameLabel = new JLabel(name);
            nameLabel.setFont(FONT_CATEGORY);
            nameLabel.setForeground(TEXT_PRIMARY);
            nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            info.add(nameLabel);
            info.add(Box.createVerticalStrut(4));

            JLabel taxLabel = new JLabel("Tax (12%): " + tax);
            taxLabel.setFont(FONT_SMALL);
            taxLabel.setForeground(TEXT_SECONDARY);
            taxLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            info.add(taxLabel);

            card.add(info, BorderLayout.CENTER);

            // Right side: price + button
            JPanel right = new JPanel();
            right.setOpaque(false);
            right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

            JLabel priceLabel = new JLabel("" + price);
            priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
            priceLabel.setForeground(accent);
            priceLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
            right.add(priceLabel);
            right.add(Box.createVerticalStrut(4));

            JLabel totalLabel = new JLabel("Total: " + total);
            totalLabel.setFont(FONT_SMALL);
            totalLabel.setForeground(TEXT_SECONDARY);
            totalLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
            right.add(totalLabel);
            right.add(Box.createVerticalStrut(10));

            // Add to Cart button
            final String itemName = name;
            final int itemTotal = total;
            JButton addBtn = createStyledButton("+ Add", SUCCESS_GREEN);
            addBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);
            addBtn.addActionListener(e -> addToCart(itemName, itemTotal));
            right.add(addBtn);

            card.add(right, BorderLayout.EAST);
            grid.add(card);
        }

        JScrollPane scroll = new JScrollPane(grid);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        panel.add(scroll, BorderLayout.CENTER);
        return panel;
    }

    private String[] getItemEmojis(String category) {
        switch (category) {
            case "Tiffin":
                return new String[] { "🥙", "🥞", "🍚", "🫓" };
            case "Veg Lunch":
                return new String[] { "🍛", "🥘", "🧀", "🥛" };
            case "Non-Veg Lunch":
                return new String[] { "🍗", "🍖", "🐟" };
            case "Dinner":
                return new String[] { "🍛", "🥘", "🍗", "🥛" };
            case "Snacks":
                return new String[] { "🥔", "🍫", "🍪", "🍪" };
            case "Beverages":
                return new String[] { "🥤", "🧃", "🥤", "🥤" };
            default:
                return new String[] {};
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // CART VIEW
    // ═══════════════════════════════════════════════════════════════
    private JPanel buildCartPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BG_DARK);

        panel.add(buildBackBar("🛒 Your Cart", ACCENT_ORANGE), BorderLayout.NORTH);

        // Cart list
        cartListModel = new DefaultListModel<>();
        JList<String> cartList = new JList<>(cartListModel);
        cartList.setBackground(BG_CARD);
        cartList.setForeground(TEXT_PRIMARY);
        cartList.setFont(FONT_ITEM);
        cartList.setSelectionBackground(ACCENT_BLUE);
        cartList.setFixedCellHeight(45);
        cartList.setBorder(new EmptyBorder(10, 15, 10, 15));
        cartList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
                label.setBorder(new EmptyBorder(8, 15, 8, 15));
                label.setFont(FONT_ITEM);
                if (!isSelected) {
                    label.setBackground(index % 2 == 0 ? BG_CARD : new Color(35, 35, 55));
                    label.setForeground(TEXT_PRIMARY);
                }
                return label;
            }
        });

        JScrollPane scroll = new JScrollPane(cartList);
        scroll.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(10, 30, 10, 30),
                BorderFactory.createLineBorder(BORDER_COLOR, 1, true)));
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        panel.add(scroll, BorderLayout.CENTER);

        // Bottom: total + actions
        JPanel bottom = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(CART_BG);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.setColor(BORDER_COLOR);
                g2.fillRect(0, 0, getWidth(), 1);
                g2.dispose();
            }
        };
        bottom.setLayout(new BorderLayout());
        bottom.setPreferredSize(new Dimension(0, 80));
        bottom.setBorder(new EmptyBorder(15, 30, 15, 30));

        JLabel totalText = new JLabel("Grand Total (incl. tax)");
        totalText.setFont(FONT_SUBTITLE);
        totalText.setForeground(TEXT_PRIMARY);
        bottom.add(totalText, BorderLayout.WEST);

        JPanel rightBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 5));
        rightBottom.setOpaque(false);

        JLabel grandTotal = new JLabel("0");
        grandTotal.setFont(new Font("Segoe UI", Font.BOLD, 24));
        grandTotal.setForeground(ACCENT_GREEN);
        grandTotal.setName("grandTotal");
        rightBottom.add(grandTotal);

        JButton clearBtn = createStyledButton("🗑 Clear", ACCENT_PINK);
        clearBtn.addActionListener(e -> {
            cart.clear();
            cartTotal = 0;
            refreshCartPanel();
            updateCartHeader();
        });
        rightBottom.add(clearBtn);

        JButton orderBtn = createStyledButton("✅ Place Order", SUCCESS_GREEN);
        orderBtn.addActionListener(e -> {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Your cart is empty!", "No Items", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "🎉 Order placed successfully!\nTotal: " + cartTotal + "\nThank you!",
                        "Order Confirmed", JOptionPane.INFORMATION_MESSAGE);
                cart.clear();
                cartTotal = 0;
                refreshCartPanel();
                updateCartHeader();
                cardLayout.show(contentPanel, "MAIN");
            }
        });
        rightBottom.add(orderBtn);

        bottom.add(rightBottom, BorderLayout.EAST);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    // ═══════════════════════════════════════════════════════════════
    // HELPER METHODS
    // ═══════════════════════════════════════════════════════════════
    private JPanel buildBackBar(String title, Color accent) {
        return buildBackBar(title, accent, "MAIN");
    }

    private JPanel buildBackBar(String title, Color accent, String backTarget) {
        JPanel bar = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(new Color(25, 25, 42));
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.setColor(accent);
                g2.fillRect(0, getHeight() - 2, getWidth(), 2);
                g2.dispose();
            }
        };
        bar.setPreferredSize(new Dimension(0, 55));
        bar.setBorder(new EmptyBorder(10, 20, 10, 20));

        JButton backBtn = createStyledButton("← Back", ACCENT_BLUE);
        backBtn.addActionListener(e -> cardLayout.show(contentPanel, backTarget));
        bar.add(backBtn, BorderLayout.WEST);

        JLabel titleLbl = new JLabel(title);
        titleLbl.setFont(FONT_SUBTITLE);
        titleLbl.setForeground(TEXT_PRIMARY);
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        bar.add(titleLbl, BorderLayout.CENTER);

        return bar;
    }

    private void addToCart(String name, int price) {
        cart.add(new String[] { name, String.valueOf(price) });
        cartTotal += price;
        updateCartHeader();

        // Show a brief toast-like feedback
        Timer timer = new Timer(100, null);
        final JWindow toast = new JWindow(this);
        JLabel toastLabel = new JLabel("  ✅ " + name + " added!  ", SwingConstants.CENTER);
        toastLabel.setFont(FONT_BUTTON);
        toastLabel.setForeground(Color.WHITE);
        toastLabel.setOpaque(true);
        toastLabel.setBackground(SUCCESS_GREEN);
        toastLabel.setBorder(new EmptyBorder(8, 16, 8, 16));
        toast.getContentPane().add(toastLabel);
        toast.pack();
        toast.setLocationRelativeTo(this);
        toast.setVisible(true);
        Timer hideTimer = new Timer(1200, e2 -> toast.dispose());
        hideTimer.setRepeats(false);
        hideTimer.start();
    }

    private void updateCartHeader() {
        cartCountLabel.setText(cart.size() + " items");
        cartTotalLabel.setText("" + cartTotal);
    }

    private void refreshCartPanel() {
        cartListModel.clear();
        for (int i = 0; i < cart.size(); i++) {
            String[] item = cart.get(i);
            cartListModel.addElement("  " + (i + 1) + ".  " + item[0] + "    —    " + item[1]);
        }
        // Update grand total label
        for (Component comp : contentPanel.getComponents()) {
            updateGrandTotalRecursive(comp);
        }
    }

    private void updateGrandTotalRecursive(Component comp) {
        if (comp instanceof JLabel && "grandTotal".equals(comp.getName())) {
            ((JLabel) comp).setText("" + cartTotal);
        }
        if (comp instanceof Container) {
            for (Component child : ((Container) comp).getComponents()) {
                updateGrandTotalRecursive(child);
            }
        }
    }

    private JButton createStyledButton(String text, Color accent) {
        JButton btn = new JButton(text) {
            boolean hovered = false;
            {
                setContentAreaFilled(false);
                setFocusPainted(false);
                setBorderPainted(false);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                        hovered = true;
                        repaint();
                    }

                    public void mouseExited(MouseEvent e) {
                        hovered = false;
                        repaint();
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (hovered) {
                    g2.setColor(accent);
                } else {
                    g2.setColor(new Color(accent.getRed(), accent.getGreen(), accent.getBlue(), 40));
                }
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 14, 14);
                g2.setColor(accent);
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 14, 14);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(FONT_BUTTON);
        btn.setForeground(TEXT_PRIMARY);
        btn.setPreferredSize(new Dimension(110, 36));
        return btn;
    }

    // ═══════════════════════════════════════════════════════════════
    // MAIN
    // ═══════════════════════════════════════════════════════════════
    public static void main(String[] args) {
        // Set system look feel hints
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            /* ignore */ }

        // Force anti-aliased text
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");

        SwingUtilities.invokeLater(CanteenGUI::new);
    }
}
