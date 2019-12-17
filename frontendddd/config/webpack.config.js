const path = require('path');

module.exports = {
    entry: {
      app: './index.js'
    },
    output: {
      filename: 'bundle.js',
      path: path.resolve(__dirname, 'dist')
    },
    module: {
        rules: [
            {
              test: /\.s(c|a)ss$/,
              use: [
                'vue-style-loader',
                'css-loader',
                {
                  loader: 'sass-loader',
                  // Requires sass-loader@^7.0.0
                  options: {
                    implementation: require('sass'),
                    fiber: require('fibers'),
                    indentedSyntax: true // optional
                  },
                  // Requires sass-loader@^8.0.0
                  options: {
                    implementation: require('sass'),
                    sassOptions: {
                      fiber: require('fibers'),
                      indentedSyntax: true // optional
                    },
                  },
                },
              ],
            },
          ],
    }
  }